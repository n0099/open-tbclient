package d.b.i0.p3.j.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import d.b.b.a.f;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<PendantData> f58946e;

    /* renamed from: f  reason: collision with root package name */
    public f f58947f;

    /* renamed from: g  reason: collision with root package name */
    public b f58948g;

    /* renamed from: d.b.i0.p3.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1457a implements View.OnClickListener {
        public View$OnClickListenerC1457a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f58948g != null) {
                c cVar = (c) view.getTag();
                if (cVar.f58951b.getTag() instanceof Integer) {
                    Integer num = (Integer) cVar.f58951b.getTag();
                    if (a.this.f58946e.size() <= num.intValue()) {
                        return;
                    }
                    a.this.f58948g.a(view, num.intValue(), (PendantData) a.this.f58946e.get(num.intValue()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i, PendantData pendantData);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f58950a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f58951b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f58952c;

        public c(a aVar) {
        }
    }

    public a(f fVar) {
        this.f58947f = fVar;
    }

    public void c(List<PendantData> list) {
        if (list == null) {
            return;
        }
        this.f58946e = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        this.f58948g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PendantData> list = this.f58946e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.f58947f.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            cVar = new c(this);
            cVar.f58950a = (TextView) view.findViewById(R.id.cover_text);
            cVar.f58951b = (TbImageView) view.findViewById(R.id.pendant_image);
            cVar.f58952c = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            cVar.f58951b.setDefaultBgResource(R.color.transparent);
            cVar.f58951b.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View$OnClickListenerC1457a());
            view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        PendantData pendantData = this.f58946e.get(i);
        if (pendantData != null) {
            cVar.f58951b.setTag(Integer.valueOf(i));
            int i2 = pendantData.pendantType;
            if (i2 == 0) {
                cVar.f58950a.setVisibility(0);
                cVar.f58951b.setVisibility(8);
                cVar.f58952c.setVisibility(8);
                cVar.f58950a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                cVar.f58950a.setText("No");
                cVar.f58950a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            } else if (i2 == 1) {
                cVar.f58950a.setVisibility(0);
                cVar.f58951b.setVisibility(8);
                cVar.f58952c.setVisibility(8);
                cVar.f58950a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f58950a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                cVar.f58950a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            } else if (i2 == 2) {
                cVar.f58950a.setVisibility(0);
                cVar.f58951b.setVisibility(8);
                cVar.f58952c.setVisibility(8);
                cVar.f58950a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f58950a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                cVar.f58950a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            } else if (i2 != 3) {
                cVar.f58950a.setVisibility(8);
                cVar.f58951b.setVisibility(0);
                cVar.f58952c.setVisibility(8);
                cVar.f58951b.W(pendantData.img, 10, false);
            } else {
                cVar.f58950a.setVisibility(0);
                cVar.f58951b.setVisibility(8);
                cVar.f58952c.setVisibility(8);
                cVar.f58950a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                cVar.f58950a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                cVar.f58950a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            }
        }
        return view;
    }
}
