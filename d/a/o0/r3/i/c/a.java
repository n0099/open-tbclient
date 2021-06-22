package d.a.o0.r3.i.c;

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
    public List<PendantData> f63867e;

    /* renamed from: f  reason: collision with root package name */
    public f f63868f;

    /* renamed from: g  reason: collision with root package name */
    public b f63869g;

    /* renamed from: d.a.o0.r3.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1630a implements View.OnClickListener {
        public View$OnClickListenerC1630a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63869g != null) {
                c cVar = (c) view.getTag();
                if (cVar.f63872b.getTag() instanceof Integer) {
                    Integer num = (Integer) cVar.f63872b.getTag();
                    if (a.this.f63867e.size() <= num.intValue()) {
                        return;
                    }
                    a.this.f63869g.a(view, num.intValue(), (PendantData) a.this.f63867e.get(num.intValue()));
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
        public TextView f63871a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f63872b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f63873c;

        public c(a aVar) {
        }
    }

    public a(f fVar) {
        this.f63868f = fVar;
    }

    public void c(List<PendantData> list) {
        if (list == null) {
            return;
        }
        this.f63867e = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        this.f63869g = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PendantData> list = this.f63867e;
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
            view = LayoutInflater.from(this.f63868f.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            cVar = new c(this);
            cVar.f63871a = (TextView) view.findViewById(R.id.cover_text);
            cVar.f63872b = (TbImageView) view.findViewById(R.id.pendant_image);
            cVar.f63873c = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            cVar.f63872b.setDefaultBgResource(R.color.transparent);
            cVar.f63872b.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View$OnClickListenerC1630a());
            view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        PendantData pendantData = this.f63867e.get(i2);
        if (pendantData != null) {
            cVar.f63872b.setTag(Integer.valueOf(i2));
            int i3 = pendantData.pendantType;
            if (i3 == 0) {
                cVar.f63871a.setVisibility(0);
                cVar.f63872b.setVisibility(8);
                cVar.f63873c.setVisibility(8);
                cVar.f63871a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                cVar.f63871a.setText("No");
                cVar.f63871a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            } else if (i3 == 1) {
                cVar.f63871a.setVisibility(0);
                cVar.f63872b.setVisibility(8);
                cVar.f63873c.setVisibility(8);
                cVar.f63871a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f63871a.setText("T");
                cVar.f63871a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            } else if (i3 == 2) {
                cVar.f63871a.setVisibility(0);
                cVar.f63872b.setVisibility(8);
                cVar.f63873c.setVisibility(8);
                cVar.f63871a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                cVar.f63871a.setText("T");
                cVar.f63871a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            } else if (i3 != 3) {
                cVar.f63871a.setVisibility(8);
                cVar.f63872b.setVisibility(0);
                cVar.f63873c.setVisibility(8);
                cVar.f63872b.U(pendantData.img, 10, false);
            } else {
                cVar.f63871a.setVisibility(0);
                cVar.f63872b.setVisibility(8);
                cVar.f63873c.setVisibility(8);
                cVar.f63871a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                cVar.f63871a.setText("T");
                cVar.f63871a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
            }
        }
        return view;
    }
}
