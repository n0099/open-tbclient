package d.b.i0.p3.i.g;

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
import d.b.b.a.f;
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public f f58931e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f58932f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f58933g;

    /* renamed from: d.b.i0.p3.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1457a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f58934e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58935f;

        public View$OnClickListenerC1457a(CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f58934e = musicList;
            this.f58935f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f58933g != null) {
                a.this.f58933g.v0(view, this.f58934e.resource, this.f58935f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f58937a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f58938b;

        /* renamed from: c  reason: collision with root package name */
        public View f58939c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58940d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58941e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f58942f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58943g;

        /* renamed from: h  reason: collision with root package name */
        public View f58944h;

        public void b(int i) {
            SkinManager.setViewTextColor(this.f58940d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f58941e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f58942f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f58943g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f58943g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f58944h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f58938b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void v0(View view, String str, int i);
    }

    public a(f fVar) {
        this.f58931e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f58932f.contains(musicList)) {
                this.f58932f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.f58932f.get(i);
    }

    public void d(c cVar) {
        this.f58933g = cVar;
    }

    public void e(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f58932f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f58931e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f58938b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f58937a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f58937a.setIsRound(true);
            bVar.f58937a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f58937a.setDefaultBgResource(R.color.transparent);
            bVar.f58937a.setBorderWidth(l.g(this.f58931e.getPageActivity(), R.dimen.ds4));
            bVar.f58937a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f58937a.setConrers(15);
            bVar.f58939c = view.findViewById(R.id.music_loading);
            bVar.f58940d = (TextView) view.findViewById(R.id.music_title);
            bVar.f58941e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f58942f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f58943g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f58944h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f58932f.get(i);
        if (musicList != null) {
            bVar.f58940d.setText(musicList.name);
            bVar.f58937a.W(musicList.image, 10, false);
            bVar.f58941e.setText(musicList.author);
            bVar.f58942f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f58939c.setVisibility(0);
            } else {
                bVar.f58939c.setVisibility(4);
            }
            if (musicList.equals(d.b.i0.p3.i.h.a.b().a())) {
                bVar.f58938b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f58937a.setDrawBorder(true);
                bVar.f58943g.setVisibility(0);
                bVar.f58939c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f58943g.setOnClickListener(new View$OnClickListenerC1457a(musicList, i));
            } else {
                bVar.f58938b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f58937a.setDrawBorder(false);
                bVar.f58943g.setVisibility(8);
            }
        }
        return view;
    }
}
