package d.a.n0.r3.i.c;

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
import d.a.c.a.f;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public f f63753e;

    /* renamed from: f  reason: collision with root package name */
    public List<MusicData> f63754f;

    /* renamed from: g  reason: collision with root package name */
    public int f63755g;

    /* renamed from: h  reason: collision with root package name */
    public String f63756h;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63757a;

        /* renamed from: b  reason: collision with root package name */
        public View f63758b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63759c;

        public a(c cVar) {
        }
    }

    public c(f fVar) {
        this.f63753e = fVar;
    }

    public void a(TextView textView, int i2, String str) {
        if (i2 <= 0) {
            return;
        }
        float g2 = l.g(this.f63753e.getPageActivity(), R.dimen.fontsize24);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(g2);
        while (textPaint.measureText(str) > i2) {
            g2 -= 1.0f;
            textPaint.setTextSize(g2);
        }
        textView.setTextSize(0, g2);
    }

    public int b() {
        return this.f63755g;
    }

    public List<MusicData> c() {
        return this.f63754f;
    }

    public void d(int i2) {
        this.f63755g = i2;
        notifyDataSetChanged();
    }

    public void e(String str) {
        this.f63756h = str;
        if (TextUtils.isEmpty(str) || this.f63754f == null) {
            return;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.f63754f.size(); i3++) {
            if (str.equals(this.f63754f.get(i3).id)) {
                i2 = i3;
            }
        }
        if (i2 == -1) {
            i2 = 1;
        }
        this.f63755g = i2;
    }

    public void f(List<MusicData> list) {
        if (list == null) {
            return;
        }
        this.f63754f = list;
        e(this.f63756h);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MusicData> list = this.f63754f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<MusicData> list = this.f63754f;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f63753e.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a(this);
            aVar.f63757a = (TbImageView) view.findViewById(R.id.music_image);
            aVar.f63759c = (TextView) view.findViewById(R.id.music_title);
            aVar.f63758b = view.findViewById(R.id.music_loading);
            aVar.f63757a.setDrawerType(1);
            aVar.f63757a.setIsRound(true);
            aVar.f63757a.setDefaultBgResource(R.color.transparent);
            aVar.f63757a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.f63757a.setBorderWidth(l.g(this.f63753e.getPageActivity(), R.dimen.ds4));
            aVar.f63757a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f63757a.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.f63754f.get(i2);
        if (musicData != null) {
            int i3 = musicData.editMusicType;
            if (i3 == 1) {
                aVar.f63757a.U(String.valueOf(R.drawable.icon_video_mute), 24, false);
            } else if (i3 != 2) {
                aVar.f63757a.U(musicData.img, 10, false);
            } else {
                aVar.f63757a.U(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
            }
            aVar.f63758b.setVisibility(4);
            aVar.f63759c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            aVar.f63759c.setText(musicData.name);
            a(aVar.f63759c, l.g(this.f63753e.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i2 == this.f63755g) {
                aVar.f63757a.setDrawBorder(true);
            } else {
                aVar.f63757a.setDrawBorder(false);
            }
            if (i2 == 0) {
                view.setPadding(l.g(this.f63753e.getPageActivity(), R.dimen.ds34), l.g(this.f63753e.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i2 == this.f63754f.size() - 1) {
                view.setPadding(l.g(this.f63753e.getPageActivity(), R.dimen.ds34), l.g(this.f63753e.getPageActivity(), R.dimen.ds44), l.g(this.f63753e.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.g(this.f63753e.getPageActivity(), R.dimen.ds28), l.g(this.f63753e.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.f63753e.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.f63753e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.f63753e.getPageActivity()).getLayoutMode().j(view);
            } else if (this.f63753e.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f63753e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.f63753e.getPageActivity()).getLayoutMode().j(view);
            }
        }
        return view;
    }
}
