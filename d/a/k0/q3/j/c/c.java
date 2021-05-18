package d.a.k0.q3.j.c;

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
    public f f59923e;

    /* renamed from: f  reason: collision with root package name */
    public List<MusicData> f59924f;

    /* renamed from: g  reason: collision with root package name */
    public int f59925g;

    /* renamed from: h  reason: collision with root package name */
    public String f59926h;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f59927a;

        /* renamed from: b  reason: collision with root package name */
        public View f59928b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59929c;

        public a(c cVar) {
        }
    }

    public c(f fVar) {
        this.f59923e = fVar;
    }

    public void a(TextView textView, int i2, String str) {
        if (i2 <= 0) {
            return;
        }
        float g2 = l.g(this.f59923e.getPageActivity(), R.dimen.fontsize24);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(g2);
        while (textPaint.measureText(str) > i2) {
            g2 -= 1.0f;
            textPaint.setTextSize(g2);
        }
        textView.setTextSize(0, g2);
    }

    public int b() {
        return this.f59925g;
    }

    public List<MusicData> c() {
        return this.f59924f;
    }

    public void d(int i2) {
        this.f59925g = i2;
        notifyDataSetChanged();
    }

    public void e(String str) {
        this.f59926h = str;
        if (TextUtils.isEmpty(str) || this.f59924f == null) {
            return;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.f59924f.size(); i3++) {
            if (str.equals(this.f59924f.get(i3).id)) {
                i2 = i3;
            }
        }
        if (i2 == -1) {
            i2 = 1;
        }
        this.f59925g = i2;
    }

    public void f(List<MusicData> list) {
        if (list == null) {
            return;
        }
        this.f59924f = list;
        e(this.f59926h);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MusicData> list = this.f59924f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<MusicData> list = this.f59924f;
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
            view = LayoutInflater.from(this.f59923e.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a(this);
            aVar.f59927a = (TbImageView) view.findViewById(R.id.music_image);
            aVar.f59929c = (TextView) view.findViewById(R.id.music_title);
            aVar.f59928b = view.findViewById(R.id.music_loading);
            aVar.f59927a.setDrawerType(1);
            aVar.f59927a.setIsRound(true);
            aVar.f59927a.setDefaultBgResource(R.color.transparent);
            aVar.f59927a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.f59927a.setBorderWidth(l.g(this.f59923e.getPageActivity(), R.dimen.ds4));
            aVar.f59927a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            aVar.f59927a.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.f59924f.get(i2);
        if (musicData != null) {
            int i3 = musicData.editMusicType;
            if (i3 == 1) {
                aVar.f59927a.V(String.valueOf(R.drawable.icon_video_mute), 24, false);
            } else if (i3 != 2) {
                aVar.f59927a.V(musicData.img, 10, false);
            } else {
                aVar.f59927a.V(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
            }
            aVar.f59928b.setVisibility(4);
            aVar.f59929c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            aVar.f59929c.setText(musicData.name);
            a(aVar.f59929c, l.g(this.f59923e.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i2 == this.f59925g) {
                aVar.f59927a.setDrawBorder(true);
            } else {
                aVar.f59927a.setDrawBorder(false);
            }
            if (i2 == 0) {
                view.setPadding(l.g(this.f59923e.getPageActivity(), R.dimen.ds34), l.g(this.f59923e.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i2 == this.f59924f.size() - 1) {
                view.setPadding(l.g(this.f59923e.getPageActivity(), R.dimen.ds34), l.g(this.f59923e.getPageActivity(), R.dimen.ds44), l.g(this.f59923e.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.g(this.f59923e.getPageActivity(), R.dimen.ds28), l.g(this.f59923e.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.f59923e.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.f59923e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.f59923e.getPageActivity()).getLayoutMode().j(view);
            } else if (this.f59923e.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.f59923e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.f59923e.getPageActivity()).getLayoutMode().j(view);
            }
        }
        return view;
    }
}
