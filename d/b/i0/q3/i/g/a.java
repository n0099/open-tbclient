package d.b.i0.q3.i.g;

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
    public f f60599e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f60600f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public c f60601g;

    /* renamed from: d.b.i0.q3.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1520a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f60602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f60603f;

        public View$OnClickListenerC1520a(CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f60602e = musicList;
            this.f60603f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f60601g != null) {
                a.this.f60601g.v0(view, this.f60602e.resource, this.f60603f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60605a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f60606b;

        /* renamed from: c  reason: collision with root package name */
        public View f60607c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60608d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60609e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60610f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60611g;

        /* renamed from: h  reason: collision with root package name */
        public View f60612h;

        public void b(int i) {
            SkinManager.setViewTextColor(this.f60608d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60609e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f60610f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f60611g, R.color.common_color_10140);
            SkinManager.setBackgroundResource(this.f60611g, R.drawable.bg_music_choose);
            SkinManager.setBackgroundColor(this.f60612h, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f60606b, R.drawable.btn_icon_play_video_n);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void v0(View view, String str, int i);
    }

    public a(f fVar) {
        this.f60599e = fVar;
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        if (list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f60600f.contains(musicList)) {
                this.f60600f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i) {
        return this.f60600f.get(i);
    }

    public void d(c cVar) {
        this.f60601g = cVar;
    }

    public void e(int i, boolean z) {
        getItem(i).isLoading = z;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f60600f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f60599e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
            bVar = new b();
            bVar.f60606b = (TbImageView) view.findViewById(R.id.music_state);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
            bVar.f60605a = tbImageView;
            tbImageView.setDrawerType(1);
            bVar.f60605a.setIsRound(true);
            bVar.f60605a.setDefaultResource(R.drawable.bg_video_cloudmusic);
            bVar.f60605a.setDefaultBgResource(R.color.transparent);
            bVar.f60605a.setBorderWidth(l.g(this.f60599e.getPageActivity(), R.dimen.ds4));
            bVar.f60605a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
            bVar.f60605a.setConrers(15);
            bVar.f60607c = view.findViewById(R.id.music_loading);
            bVar.f60608d = (TextView) view.findViewById(R.id.music_title);
            bVar.f60609e = (TextView) view.findViewById(R.id.music_author_name);
            bVar.f60610f = (TextView) view.findViewById(R.id.music_duration);
            bVar.f60611g = (TextView) view.findViewById(R.id.music_choose);
            bVar.f60612h = view.findViewById(R.id.line);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.b(TbadkCoreApplication.getInst().getSkinType());
        CloudMusicData.MusicTagList.MusicList musicList = this.f60600f.get(i);
        if (musicList != null) {
            bVar.f60608d.setText(musicList.name);
            bVar.f60605a.W(musicList.image, 10, false);
            bVar.f60609e.setText(musicList.author);
            bVar.f60610f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
            if (musicList.isLoading) {
                bVar.f60607c.setVisibility(0);
            } else {
                bVar.f60607c.setVisibility(4);
            }
            if (musicList.equals(d.b.i0.q3.i.h.a.b().a())) {
                bVar.f60606b.setImageResource(R.drawable.btn_icon_stop_video);
                bVar.f60605a.setDrawBorder(true);
                bVar.f60611g.setVisibility(0);
                bVar.f60607c.setVisibility(4);
                musicList.isLoading = false;
                bVar.f60611g.setOnClickListener(new View$OnClickListenerC1520a(musicList, i));
            } else {
                bVar.f60606b.setImageResource(R.drawable.btn_icon_play_video_n);
                bVar.f60605a.setDrawBorder(false);
                bVar.f60611g.setVisibility(8);
            }
        }
        return view;
    }
}
