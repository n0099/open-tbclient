package d.b.i0.p3.j.c;

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
import d.b.b.a.f;
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public f f58958e;

    /* renamed from: f  reason: collision with root package name */
    public List<MusicData> f58959f;

    /* renamed from: g  reason: collision with root package name */
    public int f58960g;

    /* renamed from: h  reason: collision with root package name */
    public String f58961h;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f58962a;

        /* renamed from: b  reason: collision with root package name */
        public View f58963b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58964c;

        public a(c cVar) {
        }
    }

    public c(f fVar) {
        this.f58958e = fVar;
    }

    public void a(TextView textView, int i, String str) {
        if (i <= 0) {
            return;
        }
        float g2 = l.g(this.f58958e.getPageActivity(), R.dimen.fontsize24);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(g2);
        while (textPaint.measureText(str) > i) {
            g2 -= 1.0f;
            textPaint.setTextSize(g2);
        }
        textView.setTextSize(0, g2);
    }

    public int b() {
        return this.f58960g;
    }

    public List<MusicData> c() {
        return this.f58959f;
    }

    public void d(int i) {
        this.f58960g = i;
        notifyDataSetChanged();
    }

    public void e(String str) {
        this.f58961h = str;
        if (TextUtils.isEmpty(str) || this.f58959f == null) {
            return;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.f58959f.size(); i2++) {
            if (str.equals(this.f58959f.get(i2).id)) {
                i = i2;
            }
        }
        if (i == -1) {
            i = 1;
        }
        this.f58960g = i;
    }

    public void f(List<MusicData> list) {
        if (list == null) {
            return;
        }
        this.f58959f = list;
        e(this.f58961h);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MusicData> list = this.f58959f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<MusicData> list = this.f58959f;
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
            view = LayoutInflater.from(this.f58958e.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a(this);
            aVar.f58962a = (TbImageView) view.findViewById(R.id.music_image);
            aVar.f58964c = (TextView) view.findViewById(R.id.music_title);
            aVar.f58963b = view.findViewById(R.id.music_loading);
            aVar.f58962a.setDrawerType(1);
            aVar.f58962a.setIsRound(true);
            aVar.f58962a.setDefaultBgResource(R.color.transparent);
            aVar.f58962a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.f58962a.setBorderWidth(l.g(this.f58958e.getPageActivity(), R.dimen.ds4));
            aVar.f58962a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f58962a.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.f58959f.get(i);
        if (musicData != null) {
            int i2 = musicData.editMusicType;
            if (i2 == 1) {
                aVar.f58962a.W(String.valueOf(R.drawable.icon_video_mute), 24, false);
            } else if (i2 != 2) {
                aVar.f58962a.W(musicData.img, 10, false);
            } else {
                aVar.f58962a.W(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
            }
            aVar.f58963b.setVisibility(4);
            aVar.f58964c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            aVar.f58964c.setText(musicData.name);
            a(aVar.f58964c, l.g(this.f58958e.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.f58960g) {
                aVar.f58962a.setDrawBorder(true);
            } else {
                aVar.f58962a.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.g(this.f58958e.getPageActivity(), R.dimen.ds34), l.g(this.f58958e.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.f58959f.size() - 1) {
                view.setPadding(l.g(this.f58958e.getPageActivity(), R.dimen.ds34), l.g(this.f58958e.getPageActivity(), R.dimen.ds44), l.g(this.f58958e.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.g(this.f58958e.getPageActivity(), R.dimen.ds28), l.g(this.f58958e.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.f58958e.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.f58958e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.f58958e.getPageActivity()).getLayoutMode().j(view);
            } else if (this.f58958e.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f58958e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.f58958e.getPageActivity()).getLayoutMode().j(view);
            }
        }
        return view;
    }
}
