package d.a.n0.r3.m;

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
    public List<StickerItem> f60301e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f60302f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60303e;

        public a(int i2) {
            this.f60303e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f60301e.get(this.f60303e * 2)).isSelect || k.this.f60302f == null) {
                return;
            }
            k.this.f60302f.onStickerChoosed((StickerItem) k.this.f60301e.get(this.f60303e * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60305e;

        public b(int i2) {
            this.f60305e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f60301e.get((this.f60305e * 2) + 1)).isSelect || k.this.f60302f == null) {
                return;
            }
            k.this.f60302f.onStickerChoosed((StickerItem) k.this.f60301e.get((this.f60305e * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f60307a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f60308b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f60309c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f60310d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f60311e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f60312f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f60313g;

        public c(k kVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i2) {
        return (StickerItem) ListUtils.getItem(this.f60301e, i2);
    }

    public void d(List<StickerItem> list) {
        this.f60301e = list;
    }

    public void e(VideoEffectLayout.h hVar) {
        this.f60302f = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f60301e)) {
            return 0;
        }
        return (int) Math.ceil(this.f60301e.size() / 2.0d);
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
            cVar.f60309c = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f60310d = (TbImageView) view.findViewById(R.id.bottom_sticker);
            cVar.f60307a = (RelativeLayout) view.findViewById(R.id.top_container);
            cVar.f60313g = (ImageView) view.findViewById(R.id.no_sticker);
            cVar.f60308b = (RelativeLayout) view.findViewById(R.id.bottom_container);
            cVar.f60311e = (ProgressBar) view.findViewById(R.id.top_progressbar);
            cVar.f60312f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f60309c.setAutoChangeStyle(false);
        cVar.f60310d.setAutoChangeStyle(false);
        cVar.f60309c.setGifIconSupport(false);
        cVar.f60310d.setGifIconSupport(false);
        int i3 = i2 * 2;
        if (ListUtils.getItem(this.f60301e, i3) instanceof StickerItem) {
            cVar.f60307a.setVisibility(0);
            if (this.f60301e.get(i3).id == -1) {
                cVar.f60313g.setVisibility(0);
                cVar.f60309c.setVisibility(8);
                cVar.f60313g.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                cVar.f60313g.setVisibility(8);
                cVar.f60309c.setVisibility(0);
                cVar.f60309c.V(this.f60301e.get(i3).img, 10, true);
            }
            cVar.f60307a.setOnClickListener(new a(i2));
            if (this.f60301e.get(i3).isDownLoading) {
                cVar.f60311e.setVisibility(0);
            } else {
                cVar.f60311e.setVisibility(8);
            }
            if (this.f60301e.get(i3).isSelect) {
                SkinManager.setBackgroundResource(cVar.f60307a, R.drawable.bg_select_sticker);
            } else {
                cVar.f60307a.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f60307a.setVisibility(8);
        }
        int i4 = i3 + 1;
        if (ListUtils.getItem(this.f60301e, i4) instanceof StickerItem) {
            cVar.f60308b.setVisibility(0);
            cVar.f60310d.V(this.f60301e.get(i4).img, 10, true);
            cVar.f60308b.setOnClickListener(new b(i2));
            if (this.f60301e.get(i4).isDownLoading) {
                cVar.f60312f.setVisibility(0);
            } else {
                cVar.f60312f.setVisibility(8);
            }
            if (this.f60301e.get(i4).isSelect) {
                SkinManager.setBackgroundResource(cVar.f60308b, R.drawable.bg_select_sticker);
            } else {
                cVar.f60308b.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f60308b.setVisibility(8);
        }
        return view;
    }
}
