package d.a.o0.r3.h.g;

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
    public f f63851e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f63852f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f63853g;

    /* renamed from: d.a.o0.r3.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1629a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f63854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f63855f;

        public View$OnClickListenerC1629a(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f63854e = musicList;
            this.f63855f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63853g != null) {
                a.this.f63853g.A0(view, this.f63854e.resource, this.f63855f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63857a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f63858b;

        /* renamed from: c  reason: collision with root package name */
        public View f63859c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63860d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63861e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63862f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f63863g;

        /* renamed from: h  reason: collision with root package name */
        public View f63864h;

        public void b(int i2) {
            SkinManager.setViewTextColor(this.f63860d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f63861e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f63862f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f63863g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f63863g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f63864h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f63858b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void A0(View view, String str, int i2);
    }

    public a(f fVar) {
        this.f63851e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f63852f.contains(musicList)) {
                this.f63852f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        return this.f63852f.get(i2);
    }

    public void d(c cVar) {
        this.f63853g = cVar;
    }

    public void e(int i2, boolean z) {
        getItem(i2).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f63852f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f63851e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f63858b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f63857a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f63857a.setIsRound(true);
            bVar.f63857a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f63857a.setDefaultBgResource(R.color.transparent);
            bVar.f63857a.setBorderWidth(l.g(this.f63851e.getPageActivity(), R.dimen.ds4));
            bVar.f63857a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f63857a.setConrers(15);
            bVar.f63859c = view.findViewById(R.id.music_loading);
            bVar.f63860d = (TextView) view.findViewById(R.id.music_title);
            bVar.f63861e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f63862f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f63863g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f63864h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f63852f.get(i2);
        if (musicList != null) {
            bVar.f63860d.setText(musicList.name);
            bVar.f63857a.U(musicList.image, 10, false);
            bVar.f63861e.setText(musicList.author);
            bVar.f63862f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f63859c.setVisibility(0);
            } else {
                bVar.f63859c.setVisibility(4);
            }
            if (musicList.equals(d.a.o0.r3.h.h.a.b().a())) {
                bVar.f63858b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f63857a.setDrawBorder(true);
                bVar.f63863g.setVisibility(0);
                bVar.f63859c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f63863g.setOnClickListener(new View$OnClickListenerC1629a(musicList, i2));
            } else {
                bVar.f63858b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f63857a.setDrawBorder(false);
                bVar.f63863g.setVisibility(8);
            }
        }
        return view;
    }
}
