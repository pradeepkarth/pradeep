package com.example.ceoit.swipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class MainActivity extends ListActivity
{
    StableArrayAdapter mAdapter;
    ListView mListView;
    BackgroundContainer mBackgroundContainer;
    ArrayList<String> cheeseList;
    ListViewAnimationHelper lhelper;
//    ArrayAdapter<String> mAdapter;
    private static final String SOAP_ACTION = "http://tempuri.org/TaskEvents";
    private static final String METHOD_NAME = "TaskEvents";
    private static final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
    private static final String URL = "http://172.20.1.48/scomp_ws/service.asmx";


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_list_view_deletion);
        mBackgroundContainer = (BackgroundContainer) findViewById(R.id.listViewBackground);
//         Set up ListView example
        String[] items = new String[2];
        for (int i = 0; i < items.length; i++)
        {
            items[i] = "Item " + (i + 1);
        }
//        mBackgroundContainer = (BackgroundContainer) findViewById(R.id.listViewBackground);
//        mListView = (ListView) findViewById(R.id.listview);
//        android.util.Log.d("Debug", "d=" + mListView.getDivider());
        cheeseList=new ArrayList<String>();
        cheeseList.add("mhjgdfjhgfkjg");
        cheeseList.add("ljogrek';lkk'dehiuh");
//        mAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                new ArrayList<String>(Arrays.asList(items)));
//        setListAdapter(mAdapter);
        mAdapter = new StableArrayAdapter(MainActivity.this,R.layout.opaque_text_view, cheeseList);
//        mListView.setAdapter(mAdapter);
        setListAdapter(mAdapter);


        ListView listView = getListView();
        // Create a ListView-specific touch listener. ListViews are given special treatment because
        // by default they handle touches for their list items... i.e. they're in charge of drawing
        // the pressed state (the list selector), handling list item clicks, etc.
        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        listView,
                        new SwipeDismissListViewTouchListener.OnDismissCallback() {
                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    mAdapter.remove(mAdapter.getItem(position));
                                }
                                mAdapter.notifyDataSetChanged();
                            }
                        });
        listView.setOnTouchListener(touchListener);
        // Setting this scroll listener is required to ensure that during ListView scrolling,
        // we don't look for swipes.
        listView.setOnScrollListener(touchListener.makeScrollListener());

//        lhelper=new ListViewAnimationHelper(mAdapter, listView, cheeseList);

    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id)
    {
        Toast.makeText(this,
                "Clicked " + getListAdapter().getItem(position).toString(),
                Toast.LENGTH_SHORT).show();

    }


//    public class Cheeses extends AsyncTask<String, Void, Void> {
//        ProgressDialog mProgressDialog;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            mProgressDialog = ProgressDialog.show(MainActivity.this, "Loading","please wait...", true);
//        }
//
//        @Override
//        protected Void doInBackground(String... params) {
//
////            cal = Calendar.getInstance();
////        String[] str = new String[10];
//            try {
//                SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,
//                        METHOD_NAME);
//                request.addProperty("userid",/* sp1.getString("userid",null)*/);
////                request.addProperty("month", Integer.toString((cal.MONTH)-1));
//                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//                        SoapEnvelope.VER11);
//                envelope.dotNet = true;
//                envelope.setOutputSoapObject(request);
//                HttpTransportSE httpTransport = new HttpTransportSE(URL, 2100000000);
//                httpTransport.call(SOAP_ACTION, envelope);
//                SoapObject object = (SoapObject) envelope.getResponse();
//                SoapObject object1 = (SoapObject) object.getProperty(0);
//
//                if (!((SoapObject) object1.getProperty(0)).hasProperty("result"))
//                    for (int i = 0; i < object1.getPropertyCount(); i++) {
//                        String j =
//                                ((SoapObject) object1.getProperty(i)).getProperty("Eventid").toString()+ ":" +
//                                        ((SoapObject) object1.getProperty(i)).getProperty("Eventday").toString() + ":" +
//                                        ((SoapObject) object1.getProperty(i)).getProperty("form").toString() + ":" +
//                                        ((SoapObject) object1.getProperty(i)).getProperty("name").toString();
//                        cheeseList.add(j);
//
//
//
//
//                    }
//            } catch (Exception e) {
//                String j = "";
////            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
//            }
//
//            return null;
//
//
//        }
//        @Override
//        protected void onPostExecute(Void result){
//            super.onPostExecute(result);
//            // this method will be running on UI thread
//            if (mProgressDialog != null) {
//                if (mProgressDialog.isShowing()) {
//                    mProgressDialog.dismiss();
//                }
//
//            }
//            mAdapter = new StableArrayAdapter(ListViewRemovalAnimation.this,R.layout.opaque_text_view, cheeseList,
//                    mTouchListener);
//            mListView.setAdapter(mAdapter);
//        }
//    }


}