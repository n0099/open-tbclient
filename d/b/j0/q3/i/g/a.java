package d.b.j0.q3.i.g;

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
import d.b.c.a.f;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public f f61020e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f61021f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f61022g;

    /* renamed from: d.b.j0.q3.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1543a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f61023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f61024f;

        public View$OnClickListenerC1543a(CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f61023e = musicList;
            this.f61024f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f61022g != null) {
                a.this.f61022g.v0(view, this.f61023e.resource, this.f61024f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61026a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61027b;

        /* renamed from: c  reason: collision with root package name */
        public View f61028c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61029d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61030e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61031f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61032g;

        /* renamed from: h  reason: collision with root package name */
        public View f61033h;

        public void b(int i) {
            SkinManager.setViewTextColor(this.f61029d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f61030e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f61031f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f61032g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f61032g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f61033h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f61027b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void v0(View view, String str, int i);
    }

    public a(f fVar) {
        this.f61020e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f61021f.contains(musicList)) {
                this.f61021f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.f61021f.get(i);
    }

    public void d(c cVar) {
        this.f61022g = cVar;
    }

    public void e(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f61021f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f61020e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f61027b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f61026a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f61026a.setIsRound(true);
            bVar.f61026a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f61026a.setDefaultBgResource(R.color.transparent);
            bVar.f61026a.setBorderWidth(l.g(this.f61020e.getPageActivity(), R.dimen.ds4));
            bVar.f61026a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f61026a.setConrers(15);
            bVar.f61028c = view.findViewById(R.id.music_loading);
            bVar.f61029d = (TextView) view.findViewById(R.id.music_title);
            bVar.f61030e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f61031f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f61032g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f61033h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f61021f.get(i);
        if (musicList != null) {
            bVar.f61029d.setText(musicList.name);
            bVar.f61026a.W(musicList.image, 10, false);
            bVar.f61030e.setText(musicList.author);
            bVar.f61031f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f61028c.setVisibility(0);
            } else {
                bVar.f61028c.setVisibility(4);
            }
            if (musicList.equals(d.b.j0.q3.i.h.a.b().a())) {
                bVar.f61027b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f61026a.setDrawBorder(true);
                bVar.f61032g.setVisibility(0);
                bVar.f61028c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f61032g.setOnClickListener(new View$OnClickListenerC1543a(musicList, i));
            } else {
                bVar.f61027b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f61026a.setDrawBorder(false);
                bVar.f61032g.setVisibility(8);
            }
        }
        return view;
    }
}
