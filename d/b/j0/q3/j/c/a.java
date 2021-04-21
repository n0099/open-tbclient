package d.b.j0.q3.j.c;

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
import d.b.c.a.f;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<PendantData> f61036e;

    /* renamed from: f  reason: collision with root package name */
    public f f61037f;

    /* renamed from: g  reason: collision with root package name */
    public b f61038g;

    /* renamed from: d.b.j0.q3.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1544a implements View.OnClickListener {
        public View$OnClickListenerC1544a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61038g != null) {
                c cVar = (c) view.getTag();
                if (cVar.f61041b.getTag() instanceof Integer) {
                    Integer num = (Integer) cVar.f61041b.getTag();
                    if (a.this.f61036e.size() <= num.intValue()) {
                        return;
                    }
                    a.this.f61038g.a(view, num.intValue(), (PendantData) a.this.f61036e.get(num.intValue()));
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
        public TextView f61040a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61041b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f61042c;

        public c(a aVar) {
        }
    }

    public a(f fVar) {
        this.f61037f = fVar;
    }

    public void c(List<PendantData> list) {
        if (list == null) {
            return;
        }
        this.f61036e = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        this.f61038g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PendantData> list = this.f61036e;
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
            view = LayoutInflater.from(this.f61037f.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            cVar = new c(this);
            cVar.f61040a = (TextView) view.findViewById(R.id.cover_text);
            cVar.f61041b = (TbImageView) view.findViewById(R.id.pendant_image);
            cVar.f61042c = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            cVar.f61041b.setDefaultBgResource(R.color.transparent);
            cVar.f61041b.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View$OnClickListenerC1544a());
            view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        PendantData pendantData = this.f61036e.get(i);
        if (pendantData != null) {
            cVar.f61041b.setTag(Integer.valueOf(i));
            int i2 = pendantData.pendantType;
            if (i2 == 0) {
                cVar.f61040a.setVisibility(0);
                cVar.f61041b.setVisibility(8);
                cVar.f61042c.setVisibility(8);
                cVar.f61040a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                cVar.f61040a.setText("No");
                cVar.f61040a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            } else if (i2 == 1) {
                cVar.f61040a.setVisibility(0);
                cVar.f61041b.setVisibility(8);
                cVar.f61042c.setVisibility(8);
                cVar.f61040a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f61040a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                cVar.f61040a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            } else if (i2 == 2) {
                cVar.f61040a.setVisibility(0);
                cVar.f61041b.setVisibility(8);
                cVar.f61042c.setVisibility(8);
                cVar.f61040a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f61040a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                cVar.f61040a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            } else if (i2 != 3) {
                cVar.f61040a.setVisibility(8);
                cVar.f61041b.setVisibility(0);
                cVar.f61042c.setVisibility(8);
                cVar.f61041b.W(pendantData.img, 10, false);
            } else {
                cVar.f61040a.setVisibility(0);
                cVar.f61041b.setVisibility(8);
                cVar.f61042c.setVisibility(8);
                cVar.f61040a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                cVar.f61040a.setText(ExifInterface.GPS_DIRECTION_TRUE);
                cVar.f61040a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            }
        }
        return view;
    }
}
