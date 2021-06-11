package d.a.n0.r3.h.g;

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
    public f f63726e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f63727f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f63728g;

    /* renamed from: d.a.n0.r3.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1625a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f63729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f63730f;

        public View$OnClickListenerC1625a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f63729e = musicList;
            this.f63730f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63728g != null) {
                a.this.f63728g.A0(view, this.f63729e.resource, this.f63730f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63732a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f63733b;

        /* renamed from: c  reason: collision with root package name */
        public View f63734c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63735d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63736e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63737f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63738g;

        /* renamed from: h  reason: collision with root package name */
        public View f63739h;

        public void b(int i2) {
            SkinManager.setViewTextColor(this.f63735d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f63736e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f63737f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f63738g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f63738g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f63739h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f63733b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void A0(View view, String str, int i2);
    }

    public a(f fVar) {
        this.f63726e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f63727f.contains(musicList)) {
                this.f63727f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        return this.f63727f.get(i2);
    }

    public void d(c cVar) {
        this.f63728g = cVar;
    }

    public void e(int i2, boolean z) {
        getItem(i2).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f63727f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f63726e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f63733b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f63732a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f63732a.setIsRound(true);
            bVar.f63732a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f63732a.setDefaultBgResource(R.color.transparent);
            bVar.f63732a.setBorderWidth(l.g(this.f63726e.getPageActivity(), R.dimen.ds4));
            bVar.f63732a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f63732a.setConrers(15);
            bVar.f63734c = view.findViewById(R.id.music_loading);
            bVar.f63735d = (TextView) view.findViewById(R.id.music_title);
            bVar.f63736e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f63737f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f63738g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f63739h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f63727f.get(i2);
        if (musicList != null) {
            bVar.f63735d.setText(musicList.name);
            bVar.f63732a.U(musicList.image, 10, false);
            bVar.f63736e.setText(musicList.author);
            bVar.f63737f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f63734c.setVisibility(0);
            } else {
                bVar.f63734c.setVisibility(4);
            }
            if (musicList.equals(d.a.n0.r3.h.h.a.b().a())) {
                bVar.f63733b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f63732a.setDrawBorder(true);
                bVar.f63738g.setVisibility(0);
                bVar.f63734c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f63738g.setOnClickListener(new View$OnClickListenerC1625a(musicList, i2));
            } else {
                bVar.f63733b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f63732a.setDrawBorder(false);
                bVar.f63738g.setVisibility(8);
            }
        }
        return view;
    }
}
