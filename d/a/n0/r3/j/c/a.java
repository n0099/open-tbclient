package d.a.n0.r3.j.c;

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
    public List<PendantData> f60053e;

    /* renamed from: f  reason: collision with root package name */
    public f f60054f;

    /* renamed from: g  reason: collision with root package name */
    public b f60055g;

    /* renamed from: d.a.n0.r3.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1570a implements View.OnClickListener {
        public View$OnClickListenerC1570a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f60055g != null) {
                c cVar = (c) view.getTag();
                if (cVar.f60058b.getTag() instanceof Integer) {
                    Integer num = (Integer) cVar.f60058b.getTag();
                    if (a.this.f60053e.size() <= num.intValue()) {
                        return;
                    }
                    a.this.f60055g.a(view, num.intValue(), (PendantData) a.this.f60053e.get(num.intValue()));
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
        public TextView f60057a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60058b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f60059c;

        public c(a aVar) {
        }
    }

    public a(f fVar) {
        this.f60054f = fVar;
    }

    public void c(List<PendantData> list) {
        if (list == null) {
            return;
        }
        this.f60053e = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        this.f60055g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PendantData> list = this.f60053e;
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
            view = LayoutInflater.from(this.f60054f.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            cVar = new c(this);
            cVar.f60057a = (TextView) view.findViewById(R.id.cover_text);
            cVar.f60058b = (TbImageView) view.findViewById(R.id.pendant_image);
            cVar.f60059c = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            cVar.f60058b.setDefaultBgResource(R.color.transparent);
            cVar.f60058b.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View$OnClickListenerC1570a());
            view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        PendantData pendantData = this.f60053e.get(i2);
        if (pendantData != null) {
            cVar.f60058b.setTag(Integer.valueOf(i2));
            int i3 = pendantData.pendantType;
            if (i3 == 0) {
                cVar.f60057a.setVisibility(0);
                cVar.f60058b.setVisibility(8);
                cVar.f60059c.setVisibility(8);
                cVar.f60057a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                cVar.f60057a.setText("No");
                cVar.f60057a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            } else if (i3 == 1) {
                cVar.f60057a.setVisibility(0);
                cVar.f60058b.setVisibility(8);
                cVar.f60059c.setVisibility(8);
                cVar.f60057a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f60057a.setText("T");
                cVar.f60057a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            } else if (i3 == 2) {
                cVar.f60057a.setVisibility(0);
                cVar.f60058b.setVisibility(8);
                cVar.f60059c.setVisibility(8);
                cVar.f60057a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f60057a.setText("T");
                cVar.f60057a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            } else if (i3 != 3) {
                cVar.f60057a.setVisibility(8);
                cVar.f60058b.setVisibility(0);
                cVar.f60059c.setVisibility(8);
                cVar.f60058b.V(pendantData.img, 10, false);
            } else {
                cVar.f60057a.setVisibility(0);
                cVar.f60058b.setVisibility(8);
                cVar.f60059c.setVisibility(8);
                cVar.f60057a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                cVar.f60057a.setText("T");
                cVar.f60057a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            }
        }
        return view;
    }
}
