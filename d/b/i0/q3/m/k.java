package d.b.i0.q3.m;

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
    public List<StickerItem> f60853e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f60854f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60855e;

        public a(int i) {
            this.f60855e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f60853e.get(this.f60855e * 2)).isSelect || k.this.f60854f == null) {
                return;
            }
            k.this.f60854f.onStickerChoosed((StickerItem) k.this.f60853e.get(this.f60855e * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60857e;

        public b(int i) {
            this.f60857e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f60853e.get((this.f60857e * 2) + 1)).isSelect || k.this.f60854f == null) {
                return;
            }
            k.this.f60854f.onStickerChoosed((StickerItem) k.this.f60853e.get((this.f60857e * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f60859a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f60860b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f60861c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f60862d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f60863e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f60864f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f60865g;

        public c(k kVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i) {
        return (StickerItem) ListUtils.getItem(this.f60853e, i);
    }

    public void d(List<StickerItem> list) {
        this.f60853e = list;
    }

    public void e(VideoEffectLayout.h hVar) {
        this.f60854f = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f60853e)) {
            return 0;
        }
        return (int) Math.ceil(this.f60853e.size() / 2.0d);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_sticker, (ViewGroup) null);
            cVar = new c(this);
            cVar.f60861c = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f60862d = (TbImageView) view.findViewById(R.id.bottom_sticker);
            cVar.f60859a = (RelativeLayout) view.findViewById(R.id.top_container);
            cVar.f60865g = (ImageView) view.findViewById(R.id.no_sticker);
            cVar.f60860b = (RelativeLayout) view.findViewById(R.id.bottom_container);
            cVar.f60863e = (ProgressBar) view.findViewById(R.id.top_progressbar);
            cVar.f60864f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f60861c.setAutoChangeStyle(false);
        cVar.f60862d.setAutoChangeStyle(false);
        cVar.f60861c.setGifIconSupport(false);
        cVar.f60862d.setGifIconSupport(false);
        int i2 = i * 2;
        if (ListUtils.getItem(this.f60853e, i2) instanceof StickerItem) {
            cVar.f60859a.setVisibility(0);
            if (this.f60853e.get(i2).id == -1) {
                cVar.f60865g.setVisibility(0);
                cVar.f60861c.setVisibility(8);
                cVar.f60865g.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                cVar.f60865g.setVisibility(8);
                cVar.f60861c.setVisibility(0);
                cVar.f60861c.W(this.f60853e.get(i2).img, 10, true);
            }
            cVar.f60859a.setOnClickListener(new a(i));
            if (this.f60853e.get(i2).isDownLoading) {
                cVar.f60863e.setVisibility(0);
            } else {
                cVar.f60863e.setVisibility(8);
            }
            if (this.f60853e.get(i2).isSelect) {
                SkinManager.setBackgroundResource(cVar.f60859a, R.drawable.bg_select_sticker);
            } else {
                cVar.f60859a.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f60859a.setVisibility(8);
        }
        int i3 = i2 + 1;
        if (ListUtils.getItem(this.f60853e, i3) instanceof StickerItem) {
            cVar.f60860b.setVisibility(0);
            cVar.f60862d.W(this.f60853e.get(i3).img, 10, true);
            cVar.f60860b.setOnClickListener(new b(i));
            if (this.f60853e.get(i3).isDownLoading) {
                cVar.f60864f.setVisibility(0);
            } else {
                cVar.f60864f.setVisibility(8);
            }
            if (this.f60853e.get(i3).isSelect) {
                SkinManager.setBackgroundResource(cVar.f60860b, R.drawable.bg_select_sticker);
            } else {
                cVar.f60860b.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f60860b.setVisibility(8);
        }
        return view;
    }
}
