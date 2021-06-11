package d.a.n0.r3.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<StickerItem> f63990e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f63991f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63992e;

        public a(int i2) {
            this.f63992e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f63990e.get(this.f63992e * 2)).isSelect || k.this.f63991f == null) {
                return;
            }
            k.this.f63991f.onStickerChoosed((StickerItem) k.this.f63990e.get(this.f63992e * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f63994e;

        public b(int i2) {
            this.f63994e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f63990e.get((this.f63994e * 2) + 1)).isSelect || k.this.f63991f == null) {
                return;
            }
            k.this.f63991f.onStickerChoosed((StickerItem) k.this.f63990e.get((this.f63994e * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f63996a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f63997b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f63998c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f63999d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f64000e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f64001f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f64002g;

        public c(k kVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i2) {
        return (StickerItem) ListUtils.getItem(this.f63990e, i2);
    }

    public void d(List<StickerItem> list) {
        this.f63990e = list;
    }

    public void e(VideoEffectLayout.h hVar) {
        this.f63991f = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f63990e)) {
            return 0;
        }
        return (int) Math.ceil(this.f63990e.size() / 2.0d);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_sticker, (ViewGroup) null);
            cVar = new c(this);
            cVar.f63998c = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f63999d = (TbImageView) view.findViewById(R.id.bottom_sticker);
            cVar.f63996a = (RelativeLayout) view.findViewById(R.id.top_container);
            cVar.f64002g = (ImageView) view.findViewById(R.id.no_sticker);
            cVar.f63997b = (RelativeLayout) view.findViewById(R.id.bottom_container);
            cVar.f64000e = (ProgressBar) view.findViewById(R.id.top_progressbar);
            cVar.f64001f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f63998c.setAutoChangeStyle(false);
        cVar.f63999d.setAutoChangeStyle(false);
        cVar.f63998c.setGifIconSupport(false);
        cVar.f63999d.setGifIconSupport(false);
        int i3 = i2 * 2;
        if (ListUtils.getItem(this.f63990e, i3) instanceof StickerItem) {
            cVar.f63996a.setVisibility(0);
            if (this.f63990e.get(i3).id == -1) {
                cVar.f64002g.setVisibility(0);
                cVar.f63998c.setVisibility(8);
                cVar.f64002g.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                cVar.f64002g.setVisibility(8);
                cVar.f63998c.setVisibility(0);
                cVar.f63998c.U(this.f63990e.get(i3).img, 10, true);
            }
            cVar.f63996a.setOnClickListener(new a(i2));
            if (this.f63990e.get(i3).isDownLoading) {
                cVar.f64000e.setVisibility(0);
            } else {
                cVar.f64000e.setVisibility(8);
            }
            if (this.f63990e.get(i3).isSelect) {
                SkinManager.setBackgroundResource(cVar.f63996a, R.drawable.bg_select_sticker);
            } else {
                cVar.f63996a.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f63996a.setVisibility(8);
        }
        int i4 = i3 + 1;
        if (ListUtils.getItem(this.f63990e, i4) instanceof StickerItem) {
            cVar.f63997b.setVisibility(0);
            cVar.f63999d.U(this.f63990e.get(i4).img, 10, true);
            cVar.f63997b.setOnClickListener(new b(i2));
            if (this.f63990e.get(i4).isDownLoading) {
                cVar.f64001f.setVisibility(0);
            } else {
                cVar.f64001f.setVisibility(8);
            }
            if (this.f63990e.get(i4).isSelect) {
                SkinManager.setBackgroundResource(cVar.f63997b, R.drawable.bg_select_sticker);
            } else {
                cVar.f63997b.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f63997b.setVisibility(8);
        }
        return view;
    }
}
