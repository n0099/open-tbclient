package d.b.i0.q3.j.c;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import d.b.c.a.f;
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public f f60626e;

    /* renamed from: f  reason: collision with root package name */
    public List<MusicData> f60627f;

    /* renamed from: g  reason: collision with root package name */
    public int f60628g;

    /* renamed from: h  reason: collision with root package name */
    public String f60629h;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60630a;

        /* renamed from: b  reason: collision with root package name */
        public View f60631b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60632c;

        public a(c cVar) {
        }
    }

    public c(f fVar) {
        this.f60626e = fVar;
    }

    public void a(TextView textView, int i, String str) {
        if (i <= 0) {
            return;
        }
        float g2 = l.g(this.f60626e.getPageActivity(), R.dimen.fontsize24);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(g2);
        while (textPaint.measureText(str) > i) {
            g2 -= 1.0f;
            textPaint.setTextSize(g2);
        }
        textView.setTextSize(0, g2);
    }

    public int b() {
        return this.f60628g;
    }

    public List<MusicData> c() {
        return this.f60627f;
    }

    public void d(int i) {
        this.f60628g = i;
        notifyDataSetChanged();
    }

    public void e(String str) {
        this.f60629h = str;
        if (TextUtils.isEmpty(str) || this.f60627f == null) {
            return;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.f60627f.size(); i2++) {
            if (str.equals(this.f60627f.get(i2).id)) {
                i = i2;
            }
        }
        if (i == -1) {
            i = 1;
        }
        this.f60628g = i;
    }

    public void f(List<MusicData> list) {
        if (list == null) {
            return;
        }
        this.f60627f = list;
        e(this.f60629h);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MusicData> list = this.f60627f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<MusicData> list = this.f60627f;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f60626e.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a(this);
            aVar.f60630a = (TbImageView) view.findViewById(R.id.music_image);
            aVar.f60632c = (TextView) view.findViewById(R.id.music_title);
            aVar.f60631b = view.findViewById(R.id.music_loading);
            aVar.f60630a.setDrawerType(1);
            aVar.f60630a.setIsRound(true);
            aVar.f60630a.setDefaultBgResource(R.color.transparent);
            aVar.f60630a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.f60630a.setBorderWidth(l.g(this.f60626e.getPageActivity(), R.dimen.ds4));
            aVar.f60630a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f60630a.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.f60627f.get(i);
        if (musicData != null) {
            int i2 = musicData.editMusicType;
            if (i2 == 1) {
                aVar.f60630a.W(String.valueOf(R.drawable.icon_video_mute), 24, false);
            } else if (i2 != 2) {
                aVar.f60630a.W(musicData.img, 10, false);
            } else {
                aVar.f60630a.W(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
            }
            aVar.f60631b.setVisibility(4);
            aVar.f60632c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            aVar.f60632c.setText(musicData.name);
            a(aVar.f60632c, l.g(this.f60626e.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.f60628g) {
                aVar.f60630a.setDrawBorder(true);
            } else {
                aVar.f60630a.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.g(this.f60626e.getPageActivity(), R.dimen.ds34), l.g(this.f60626e.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.f60627f.size() - 1) {
                view.setPadding(l.g(this.f60626e.getPageActivity(), R.dimen.ds34), l.g(this.f60626e.getPageActivity(), R.dimen.ds44), l.g(this.f60626e.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.g(this.f60626e.getPageActivity(), R.dimen.ds28), l.g(this.f60626e.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.f60626e.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.f60626e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.f60626e.getPageActivity()).getLayoutMode().j(view);
            } else if (this.f60626e.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f60626e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.f60626e.getPageActivity()).getLayoutMode().j(view);
            }
        }
        return view;
    }
}
