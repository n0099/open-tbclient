package d.b.i0.p3.m;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends BaseAdapter implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public List<e> f59128e;

    /* renamed from: f  reason: collision with root package name */
    public String f59129f;

    /* renamed from: g  reason: collision with root package name */
    public int f59130g = -1;

    /* renamed from: h  reason: collision with root package name */
    public VideoEffectLayout.h f59131h;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f59132a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f59133b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59134c;

        /* renamed from: d  reason: collision with root package name */
        public int f59135d;

        public a(d dVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public e getItem(int i) {
        List<e> list = this.f59128e;
        if (list != null && i >= 0 && i < list.size()) {
            return this.f59128e.get(i);
        }
        return null;
    }

    public final void b(a aVar, View view, ViewGroup viewGroup) {
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
        aVar.f59132a = tbImageView;
        tbImageView.setIsRound(true);
        aVar.f59132a.setDrawerType(1);
        aVar.f59132a.setDefaultBgResource(R.color.transparent);
        aVar.f59132a.setBorderWidth(d.b.b.e.p.l.g(viewGroup.getContext(), R.dimen.ds4));
        aVar.f59132a.setConrers(15);
        aVar.f59132a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
        aVar.f59134c = (TextView) view.findViewById(R.id.tv_name);
    }

    public void c() {
        if (getItem(0) == null || getItem(0).c() != 3) {
            return;
        }
        this.f59130g = 0;
        this.f59129f = TbadkCoreApplication.getInst().getString(R.string.music_normal);
    }

    public void d() {
        if (getItem(0) == null || getItem(0).c() != 3) {
            return;
        }
        this.f59130g = 1;
        this.f59129f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
        notifyDataSetChanged();
    }

    public void e(List<e> list, String str) {
        this.f59128e = list;
        this.f59129f = str;
    }

    public void f(VideoEffectLayout.h hVar) {
        this.f59131h = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<e> list = this.f59128e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        e item = getItem(i);
        if (item == null) {
            return 0;
        }
        int c2 = item.c();
        if (c2 != 1) {
            return c2 != 3 ? 0 : 1;
        }
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        e eVar;
        if (view == null) {
            aVar = new a(this);
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                b(aVar, view, viewGroup);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.iv_loading);
                aVar.f59133b = progressBar;
                progressBar.setVisibility(4);
                SkinManager.setViewTextColor(aVar.f59134c, R.color.CAM_X0101);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_effect, (ViewGroup) null);
                b(aVar, view, viewGroup);
                aVar.f59133b = (ProgressBar) view.findViewById(R.id.iv_loading);
                aVar.f59132a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                SkinManager.setViewTextColor(aVar.f59134c, R.color.CAM_X0101);
            } else if (itemViewType == 2) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_beauty, (ViewGroup) null);
                b(aVar, view, viewGroup);
                SkinManager.setViewTextColor(aVar.f59134c, R.color.CAM_X0101);
            }
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List<e> list = this.f59128e;
        if (list != null && i >= 0 && i <= list.size() - 1 && (eVar = this.f59128e.get(i)) != null) {
            int itemViewType2 = getItemViewType(i);
            if (itemViewType2 == 0) {
                aVar.f59132a.W(String.valueOf(eVar.a()), 24, false);
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f59129f)) {
                    aVar.f59132a.setDrawBorder(true);
                } else {
                    aVar.f59132a.setDrawBorder(false);
                }
            } else if (itemViewType2 == 1) {
                MusicData musicData = (MusicData) eVar.d();
                if (musicData.editMusicType == 0) {
                    aVar.f59132a.W(musicData.img, 10, false);
                } else {
                    aVar.f59132a.W(String.valueOf(eVar.a()), 24, false);
                }
                if (this.f59130g != i) {
                    aVar.f59133b.setVisibility(4);
                } else if (aVar.f59133b.getVisibility() == 0) {
                    aVar.f59132a.setDrawBorder(false);
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f59129f)) {
                    aVar.f59132a.setDrawBorder(true);
                } else {
                    aVar.f59132a.setDrawBorder(false);
                }
            } else if (itemViewType2 == 2) {
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f59129f)) {
                    aVar.f59132a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                } else {
                    aVar.f59132a.setBackgroundResource(R.drawable.bg_beauty_item);
                }
            }
            aVar.f59132a.setTag(eVar);
            aVar.f59132a.setTag(R.id.record_video_effect_holder, aVar);
            aVar.f59132a.setOnClickListener(this);
            aVar.f59134c.setText(eVar.b());
            aVar.f59135d = i;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoEffectLayout.h hVar;
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.c() == 3 && (eVar.d() instanceof MusicData)) {
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_id", ((MusicData) eVar.d()).id);
                statisticItem.param("obj_locate", this.f59128e.indexOf(eVar) + 1);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                if (view.getResources().getString(R.string.music_cloud).equals(eVar.b()) && (hVar = this.f59131h) != null) {
                    hVar.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
                    this.f59130g = this.f59128e.indexOf(eVar);
                    this.f59129f = eVar.b();
                }
                if (!TextUtils.isEmpty(eVar.b()) && eVar.b().equals(this.f59129f)) {
                    return;
                }
                if (!eVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f59130g = this.f59128e.indexOf(eVar);
                }
            } else {
                this.f59130g = this.f59128e.indexOf(eVar);
            }
            this.f59129f = eVar.b();
            notifyDataSetChanged();
            VideoEffectLayout.h hVar2 = this.f59131h;
            if (hVar2 != null) {
                hVar2.onEffectChoosed(eVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}
