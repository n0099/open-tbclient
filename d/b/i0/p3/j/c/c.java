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
    public f f58957e;

    /* renamed from: f  reason: collision with root package name */
    public List<MusicData> f58958f;

    /* renamed from: g  reason: collision with root package name */
    public int f58959g;

    /* renamed from: h  reason: collision with root package name */
    public String f58960h;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f58961a;

        /* renamed from: b  reason: collision with root package name */
        public View f58962b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58963c;

        public a(c cVar) {
        }
    }

    public c(f fVar) {
        this.f58957e = fVar;
    }

    public void a(TextView textView, int i, String str) {
        if (i <= 0) {
            return;
        }
        float g2 = l.g(this.f58957e.getPageActivity(), R.dimen.fontsize24);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(g2);
        while (textPaint.measureText(str) > i) {
            g2 -= 1.0f;
            textPaint.setTextSize(g2);
        }
        textView.setTextSize(0, g2);
    }

    public int b() {
        return this.f58959g;
    }

    public List<MusicData> c() {
        return this.f58958f;
    }

    public void d(int i) {
        this.f58959g = i;
        notifyDataSetChanged();
    }

    public void e(String str) {
        this.f58960h = str;
        if (TextUtils.isEmpty(str) || this.f58958f == null) {
            return;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.f58958f.size(); i2++) {
            if (str.equals(this.f58958f.get(i2).id)) {
                i = i2;
            }
        }
        if (i == -1) {
            i = 1;
        }
        this.f58959g = i;
    }

    public void f(List<MusicData> list) {
        if (list == null) {
            return;
        }
        this.f58958f = list;
        e(this.f58960h);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MusicData> list = this.f58958f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<MusicData> list = this.f58958f;
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
            view = LayoutInflater.from(this.f58957e.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a(this);
            aVar.f58961a = (TbImageView) view.findViewById(R.id.music_image);
            aVar.f58963c = (TextView) view.findViewById(R.id.music_title);
            aVar.f58962b = view.findViewById(R.id.music_loading);
            aVar.f58961a.setDrawerType(1);
            aVar.f58961a.setIsRound(true);
            aVar.f58961a.setDefaultBgResource(R.color.transparent);
            aVar.f58961a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.f58961a.setBorderWidth(l.g(this.f58957e.getPageActivity(), R.dimen.ds4));
            aVar.f58961a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f58961a.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.f58958f.get(i);
        if (musicData != null) {
            int i2 = musicData.editMusicType;
            if (i2 == 1) {
                aVar.f58961a.W(String.valueOf(R.drawable.icon_video_mute), 24, false);
            } else if (i2 != 2) {
                aVar.f58961a.W(musicData.img, 10, false);
            } else {
                aVar.f58961a.W(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
            }
            aVar.f58962b.setVisibility(4);
            aVar.f58963c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            aVar.f58963c.setText(musicData.name);
            a(aVar.f58963c, l.g(this.f58957e.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.f58959g) {
                aVar.f58961a.setDrawBorder(true);
            } else {
                aVar.f58961a.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.g(this.f58957e.getPageActivity(), R.dimen.ds34), l.g(this.f58957e.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.f58958f.size() - 1) {
                view.setPadding(l.g(this.f58957e.getPageActivity(), R.dimen.ds34), l.g(this.f58957e.getPageActivity(), R.dimen.ds44), l.g(this.f58957e.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.g(this.f58957e.getPageActivity(), R.dimen.ds28), l.g(this.f58957e.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.f58957e.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.f58957e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.f58957e.getPageActivity()).getLayoutMode().j(view);
            } else if (this.f58957e.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f58957e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.f58957e.getPageActivity()).getLayoutMode().j(view);
            }
        }
        return view;
    }
}
