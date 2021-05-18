package d.a.k0.q3.m;

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
    public List<StickerItem> f60160e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f60161f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60162e;

        public a(int i2) {
            this.f60162e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f60160e.get(this.f60162e * 2)).isSelect || k.this.f60161f == null) {
                return;
            }
            k.this.f60161f.onStickerChoosed((StickerItem) k.this.f60160e.get(this.f60162e * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60164e;

        public b(int i2) {
            this.f60164e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f60160e.get((this.f60164e * 2) + 1)).isSelect || k.this.f60161f == null) {
                return;
            }
            k.this.f60161f.onStickerChoosed((StickerItem) k.this.f60160e.get((this.f60164e * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f60166a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f60167b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f60168c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f60169d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f60170e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f60171f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f60172g;

        public c(k kVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i2) {
        return (StickerItem) ListUtils.getItem(this.f60160e, i2);
    }

    public void d(List<StickerItem> list) {
        this.f60160e = list;
    }

    public void e(VideoEffectLayout.h hVar) {
        this.f60161f = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f60160e)) {
            return 0;
        }
        return (int) Math.ceil(this.f60160e.size() / 2.0d);
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
            cVar.f60168c = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f60169d = (TbImageView) view.findViewById(R.id.bottom_sticker);
            cVar.f60166a = (RelativeLayout) view.findViewById(R.id.top_container);
            cVar.f60172g = (ImageView) view.findViewById(R.id.no_sticker);
            cVar.f60167b = (RelativeLayout) view.findViewById(R.id.bottom_container);
            cVar.f60170e = (ProgressBar) view.findViewById(R.id.top_progressbar);
            cVar.f60171f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f60168c.setAutoChangeStyle(false);
        cVar.f60169d.setAutoChangeStyle(false);
        cVar.f60168c.setGifIconSupport(false);
        cVar.f60169d.setGifIconSupport(false);
        int i3 = i2 * 2;
        if (ListUtils.getItem(this.f60160e, i3) instanceof StickerItem) {
            cVar.f60166a.setVisibility(0);
            if (this.f60160e.get(i3).id == -1) {
                cVar.f60172g.setVisibility(0);
                cVar.f60168c.setVisibility(8);
                cVar.f60172g.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                cVar.f60172g.setVisibility(8);
                cVar.f60168c.setVisibility(0);
                cVar.f60168c.V(this.f60160e.get(i3).img, 10, true);
            }
            cVar.f60166a.setOnClickListener(new a(i2));
            if (this.f60160e.get(i3).isDownLoading) {
                cVar.f60170e.setVisibility(0);
            } else {
                cVar.f60170e.setVisibility(8);
            }
            if (this.f60160e.get(i3).isSelect) {
                SkinManager.setBackgroundResource(cVar.f60166a, R.drawable.bg_select_sticker);
            } else {
                cVar.f60166a.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f60166a.setVisibility(8);
        }
        int i4 = i3 + 1;
        if (ListUtils.getItem(this.f60160e, i4) instanceof StickerItem) {
            cVar.f60167b.setVisibility(0);
            cVar.f60169d.V(this.f60160e.get(i4).img, 10, true);
            cVar.f60167b.setOnClickListener(new b(i2));
            if (this.f60160e.get(i4).isDownLoading) {
                cVar.f60171f.setVisibility(0);
            } else {
                cVar.f60171f.setVisibility(8);
            }
            if (this.f60160e.get(i4).isSelect) {
                SkinManager.setBackgroundResource(cVar.f60167b, R.drawable.bg_select_sticker);
            } else {
                cVar.f60167b.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f60167b.setVisibility(8);
        }
        return view;
    }
}
