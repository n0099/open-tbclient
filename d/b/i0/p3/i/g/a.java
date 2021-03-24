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
    public f f58930e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f58931f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f58932g;

    /* renamed from: d.b.i0.p3.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1456a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f58933e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58934f;

        public View$OnClickListenerC1456a(CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f58933e = musicList;
            this.f58934f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f58932g != null) {
                a.this.f58932g.v0(view, this.f58933e.resource, this.f58934f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f58936a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f58937b;

        /* renamed from: c  reason: collision with root package name */
        public View f58938c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58939d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58940e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f58941f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58942g;

        /* renamed from: h  reason: collision with root package name */
        public View f58943h;

        public void b(int i) {
            SkinManager.setViewTextColor(this.f58939d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f58940e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f58941f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f58942g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f58942g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f58943h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f58937b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void v0(View view, String str, int i);
    }

    public a(f fVar) {
        this.f58930e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f58931f.contains(musicList)) {
                this.f58931f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.f58931f.get(i);
    }

    public void d(c cVar) {
        this.f58932g = cVar;
    }

    public void e(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f58931f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f58930e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f58937b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f58936a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f58936a.setIsRound(true);
            bVar.f58936a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f58936a.setDefaultBgResource(R.color.transparent);
            bVar.f58936a.setBorderWidth(l.g(this.f58930e.getPageActivity(), R.dimen.ds4));
            bVar.f58936a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f58936a.setConrers(15);
            bVar.f58938c = view.findViewById(R.id.music_loading);
            bVar.f58939d = (TextView) view.findViewById(R.id.music_title);
            bVar.f58940e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f58941f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f58942g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f58943h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f58931f.get(i);
        if (musicList != null) {
            bVar.f58939d.setText(musicList.name);
            bVar.f58936a.W(musicList.image, 10, false);
            bVar.f58940e.setText(musicList.author);
            bVar.f58941f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f58938c.setVisibility(0);
            } else {
                bVar.f58938c.setVisibility(4);
            }
            if (musicList.equals(d.b.i0.p3.i.h.a.b().a())) {
                bVar.f58937b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f58936a.setDrawBorder(true);
                bVar.f58942g.setVisibility(0);
                bVar.f58938c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f58942g.setOnClickListener(new View$OnClickListenerC1456a(musicList, i));
            } else {
                bVar.f58937b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f58936a.setDrawBorder(false);
                bVar.f58942g.setVisibility(8);
            }
        }
        return view;
    }
}
