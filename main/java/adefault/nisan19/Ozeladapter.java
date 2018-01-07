package adefault.nisan19;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sammas on 19.04.2017.
 */

public class Ozeladapter extends BaseAdapter {

    private List<Kisi> mKisiListesi;

    private LayoutInflater mInflater;


    public Ozeladapter(Activity activity, List<Kisi> kisiler) {

        mKisiListesi=kisiler;
        mInflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mKisiListesi.size();
    }

    @Override
    public Kisi getItem(int i) {
        return mKisiListesi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        View satirview;
        satirview=mInflater.inflate(R.layout.satirgorunum,null);

        TextView tw=(TextView) satirview.findViewById(R.id.isimsoyisim);
        ImageView rs=(ImageView) satirview.findViewById(R.id.simge);


        Kisi tmpkisi=mKisiListesi.get(i);
        tw.setText(tmpkisi.getIsim()+tmpkisi.getYas());



        if (tmpkisi.isKadinMi())
        {

            rs.setImageResource(R.drawable.female);
        }
        else
        {
            rs.setImageResource(R.drawable.man);
        }


        return satirview;
    }
}
