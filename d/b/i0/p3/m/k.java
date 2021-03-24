package d.b.i0.p3.m;

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
    public List<StickerItem> f59184e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f59185f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59186e;

        public a(int i) {
            this.f59186e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f59184e.get(this.f59186e * 2)).isSelect || k.this.f59185f == null) {
                return;
            }
            k.this.f59185f.onStickerChoosed((StickerItem) k.this.f59184e.get(this.f59186e * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59188e;

        public b(int i) {
            this.f59188e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f59184e.get((this.f59188e * 2) + 1)).isSelect || k.this.f59185f == null) {
                return;
            }
            k.this.f59185f.onStickerChoosed((StickerItem) k.this.f59184e.get((this.f59188e * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f59190a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f59191b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f59192c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f59193d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f59194e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f59195f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f59196g;

        public c(k kVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i) {
        return (StickerItem) ListUtils.getItem(this.f59184e, i);
    }

    public void d(List<StickerItem> list) {
        this.f59184e = list;
    }

    public void e(VideoEffectLayout.h hVar) {
        this.f59185f = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f59184e)) {
            return 0;
        }
        double size = this.f59184e.size();
        Double.isNaN(size);
        return (int) Math.ceil(size / 2.0d);
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
            cVar.f59192c = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f59193d = (TbImageView) view.findViewById(R.id.bottom_sticker);
            cVar.f59190a = (RelativeLayout) view.findViewById(R.id.top_container);
            cVar.f59196g = (ImageView) view.findViewById(R.id.no_sticker);
            cVar.f59191b = (RelativeLayout) view.findViewById(R.id.bottom_container);
            cVar.f59194e = (ProgressBar) view.findViewById(R.id.top_progressbar);
            cVar.f59195f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f59192c.setAutoChangeStyle(false);
        cVar.f59193d.setAutoChangeStyle(false);
        cVar.f59192c.setGifIconSupport(false);
        cVar.f59193d.setGifIconSupport(false);
        int i2 = i * 2;
        if (ListUtils.getItem(this.f59184e, i2) instanceof StickerItem) {
            cVar.f59190a.setVisibility(0);
            if (this.f59184e.get(i2).id == -1) {
                cVar.f59196g.setVisibility(0);
                cVar.f59192c.setVisibility(8);
                cVar.f59196g.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                cVar.f59196g.setVisibility(8);
                cVar.f59192c.setVisibility(0);
                cVar.f59192c.W(this.f59184e.get(i2).img, 10, true);
            }
            cVar.f59190a.setOnClickListener(new a(i));
            if (this.f59184e.get(i2).isDownLoading) {
                cVar.f59194e.setVisibility(0);
            } else {
                cVar.f59194e.setVisibility(8);
            }
            if (this.f59184e.get(i2).isSelect) {
                SkinManager.setBackgroundResource(cVar.f59190a, R.drawable.bg_select_sticker);
            } else {
                cVar.f59190a.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f59190a.setVisibility(8);
        }
        int i3 = i2 + 1;
        if (ListUtils.getItem(this.f59184e, i3) instanceof StickerItem) {
            cVar.f59191b.setVisibility(0);
            cVar.f59193d.W(this.f59184e.get(i3).img, 10, true);
            cVar.f59191b.setOnClickListener(new b(i));
            if (this.f59184e.get(i3).isDownLoading) {
                cVar.f59195f.setVisibility(0);
            } else {
                cVar.f59195f.setVisibility(8);
            }
            if (this.f59184e.get(i3).isSelect) {
                SkinManager.setBackgroundResource(cVar.f59191b, R.drawable.bg_select_sticker);
            } else {
                cVar.f59191b.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f59191b.setVisibility(8);
        }
        return view;
    }
}
