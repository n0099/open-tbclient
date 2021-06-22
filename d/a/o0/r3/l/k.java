package d.a.o0.r3.l;

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
    public List<StickerItem> f64115e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f64116f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f64117e;

        public a(int i2) {
            this.f64117e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f64115e.get(this.f64117e * 2)).isSelect || k.this.f64116f == null) {
                return;
            }
            k.this.f64116f.onStickerChoosed((StickerItem) k.this.f64115e.get(this.f64117e * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f64119e;

        public b(int i2) {
            this.f64119e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f64115e.get((this.f64119e * 2) + 1)).isSelect || k.this.f64116f == null) {
                return;
            }
            k.this.f64116f.onStickerChoosed((StickerItem) k.this.f64115e.get((this.f64119e * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f64121a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f64122b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f64123c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f64124d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f64125e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f64126f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f64127g;

        public c(k kVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i2) {
        return (StickerItem) ListUtils.getItem(this.f64115e, i2);
    }

    public void d(List<StickerItem> list) {
        this.f64115e = list;
    }

    public void e(VideoEffectLayout.h hVar) {
        this.f64116f = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f64115e)) {
            return 0;
        }
        return (int) Math.ceil(this.f64115e.size() / 2.0d);
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
            cVar.f64123c = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f64124d = (TbImageView) view.findViewById(R.id.bottom_sticker);
            cVar.f64121a = (RelativeLayout) view.findViewById(R.id.top_container);
            cVar.f64127g = (ImageView) view.findViewById(R.id.no_sticker);
            cVar.f64122b = (RelativeLayout) view.findViewById(R.id.bottom_container);
            cVar.f64125e = (ProgressBar) view.findViewById(R.id.top_progressbar);
            cVar.f64126f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f64123c.setAutoChangeStyle(false);
        cVar.f64124d.setAutoChangeStyle(false);
        cVar.f64123c.setGifIconSupport(false);
        cVar.f64124d.setGifIconSupport(false);
        int i3 = i2 * 2;
        if (ListUtils.getItem(this.f64115e, i3) instanceof StickerItem) {
            cVar.f64121a.setVisibility(0);
            if (this.f64115e.get(i3).id == -1) {
                cVar.f64127g.setVisibility(0);
                cVar.f64123c.setVisibility(8);
                cVar.f64127g.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                cVar.f64127g.setVisibility(8);
                cVar.f64123c.setVisibility(0);
                cVar.f64123c.U(this.f64115e.get(i3).img, 10, true);
            }
            cVar.f64121a.setOnClickListener(new a(i2));
            if (this.f64115e.get(i3).isDownLoading) {
                cVar.f64125e.setVisibility(0);
            } else {
                cVar.f64125e.setVisibility(8);
            }
            if (this.f64115e.get(i3).isSelect) {
                SkinManager.setBackgroundResource(cVar.f64121a, R.drawable.bg_select_sticker);
            } else {
                cVar.f64121a.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f64121a.setVisibility(8);
        }
        int i4 = i3 + 1;
        if (ListUtils.getItem(this.f64115e, i4) instanceof StickerItem) {
            cVar.f64122b.setVisibility(0);
            cVar.f64124d.U(this.f64115e.get(i4).img, 10, true);
            cVar.f64122b.setOnClickListener(new b(i2));
            if (this.f64115e.get(i4).isDownLoading) {
                cVar.f64126f.setVisibility(0);
            } else {
                cVar.f64126f.setVisibility(8);
            }
            if (this.f64115e.get(i4).isSelect) {
                SkinManager.setBackgroundResource(cVar.f64122b, R.drawable.bg_select_sticker);
            } else {
                cVar.f64122b.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f64122b.setVisibility(8);
        }
        return view;
    }
}
