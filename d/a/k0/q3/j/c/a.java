package d.a.k0.q3.j.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import d.a.c.a.f;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<PendantData> f59912e;

    /* renamed from: f  reason: collision with root package name */
    public f f59913f;

    /* renamed from: g  reason: collision with root package name */
    public b f59914g;

    /* renamed from: d.a.k0.q3.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1557a implements View.OnClickListener {
        public View$OnClickListenerC1557a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f59914g != null) {
                c cVar = (c) view.getTag();
                if (cVar.f59917b.getTag() instanceof Integer) {
                    Integer num = (Integer) cVar.f59917b.getTag();
                    if (a.this.f59912e.size() <= num.intValue()) {
                        return;
                    }
                    a.this.f59914g.a(view, num.intValue(), (PendantData) a.this.f59912e.get(num.intValue()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i2, PendantData pendantData);
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59916a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f59917b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f59918c;

        public c(a aVar) {
        }
    }

    public a(f fVar) {
        this.f59913f = fVar;
    }

    public void c(List<PendantData> list) {
        if (list == null) {
            return;
        }
        this.f59912e = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        this.f59914g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PendantData> list = this.f59912e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.f59913f.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            cVar = new c(this);
            cVar.f59916a = (TextView) view.findViewById(R.id.cover_text);
            cVar.f59917b = (TbImageView) view.findViewById(R.id.pendant_image);
            cVar.f59918c = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            cVar.f59917b.setDefaultBgResource(R.color.transparent);
            cVar.f59917b.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View$OnClickListenerC1557a());
            view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        PendantData pendantData = this.f59912e.get(i2);
        if (pendantData != null) {
            cVar.f59917b.setTag(Integer.valueOf(i2));
            int i3 = pendantData.pendantType;
            if (i3 == 0) {
                cVar.f59916a.setVisibility(0);
                cVar.f59917b.setVisibility(8);
                cVar.f59918c.setVisibility(8);
                cVar.f59916a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                cVar.f59916a.setText("No");
                cVar.f59916a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            } else if (i3 == 1) {
                cVar.f59916a.setVisibility(0);
                cVar.f59917b.setVisibility(8);
                cVar.f59918c.setVisibility(8);
                cVar.f59916a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f59916a.setText("T");
                cVar.f59916a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            } else if (i3 == 2) {
                cVar.f59916a.setVisibility(0);
                cVar.f59917b.setVisibility(8);
                cVar.f59918c.setVisibility(8);
                cVar.f59916a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f59916a.setText("T");
                cVar.f59916a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            } else if (i3 != 3) {
                cVar.f59916a.setVisibility(8);
                cVar.f59917b.setVisibility(0);
                cVar.f59918c.setVisibility(8);
                cVar.f59917b.V(pendantData.img, 10, false);
            } else {
                cVar.f59916a.setVisibility(0);
                cVar.f59917b.setVisibility(8);
                cVar.f59918c.setVisibility(8);
                cVar.f59916a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                cVar.f59916a.setText("T");
                cVar.f59916a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            }
        }
        return view;
    }
}
