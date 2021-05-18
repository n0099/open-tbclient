package d.a.k0.q3.i.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import d.a.c.a.f;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public f f59896e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f59897f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f59898g;

    /* renamed from: d.a.k0.q3.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1556a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f59899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59900f;

        public View$OnClickListenerC1556a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f59899e = musicList;
            this.f59900f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f59898g != null) {
                a.this.f59898g.x0(view, this.f59899e.resource, this.f59900f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f59902a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f59903b;

        /* renamed from: c  reason: collision with root package name */
        public View f59904c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59905d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59906e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f59907f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59908g;

        /* renamed from: h  reason: collision with root package name */
        public View f59909h;

        public void b(int i2) {
            SkinManager.setViewTextColor(this.f59905d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f59906e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f59907f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f59908g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f59908g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f59909h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f59903b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void x0(View view, String str, int i2);
    }

    public a(f fVar) {
        this.f59896e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f59897f.contains(musicList)) {
                this.f59897f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        return this.f59897f.get(i2);
    }

    public void d(c cVar) {
        this.f59898g = cVar;
    }

    public void e(int i2, boolean z) {
        getItem(i2).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f59897f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f59896e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f59903b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f59902a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f59902a.setIsRound(true);
            bVar.f59902a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f59902a.setDefaultBgResource(R.color.transparent);
            bVar.f59902a.setBorderWidth(l.g(this.f59896e.getPageActivity(), R.dimen.ds4));
            bVar.f59902a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f59902a.setConrers(15);
            bVar.f59904c = view.findViewById(R.id.music_loading);
            bVar.f59905d = (TextView) view.findViewById(R.id.music_title);
            bVar.f59906e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f59907f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f59908g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f59909h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f59897f.get(i2);
        if (musicList != null) {
            bVar.f59905d.setText(musicList.name);
            bVar.f59902a.V(musicList.image, 10, false);
            bVar.f59906e.setText(musicList.author);
            bVar.f59907f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f59904c.setVisibility(0);
            } else {
                bVar.f59904c.setVisibility(4);
            }
            if (musicList.equals(d.a.k0.q3.i.h.a.b().a())) {
                bVar.f59903b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f59902a.setDrawBorder(true);
                bVar.f59908g.setVisibility(0);
                bVar.f59904c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f59908g.setOnClickListener(new View$OnClickListenerC1556a(musicList, i2));
            } else {
                bVar.f59903b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f59902a.setDrawBorder(false);
                bVar.f59908g.setVisibility(8);
            }
        }
        return view;
    }
}
