package d.a.j0.q3.m;

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
    public List<StickerItem> f59415e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f59416f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59417e;

        public a(int i2) {
            this.f59417e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f59415e.get(this.f59417e * 2)).isSelect || k.this.f59416f == null) {
                return;
            }
            k.this.f59416f.onStickerChoosed((StickerItem) k.this.f59415e.get(this.f59417e * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59419e;

        public b(int i2) {
            this.f59419e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f59415e.get((this.f59419e * 2) + 1)).isSelect || k.this.f59416f == null) {
                return;
            }
            k.this.f59416f.onStickerChoosed((StickerItem) k.this.f59415e.get((this.f59419e * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f59421a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f59422b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f59423c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f59424d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f59425e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f59426f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f59427g;

        public c(k kVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i2) {
        return (StickerItem) ListUtils.getItem(this.f59415e, i2);
    }

    public void d(List<StickerItem> list) {
        this.f59415e = list;
    }

    public void e(VideoEffectLayout.h hVar) {
        this.f59416f = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f59415e)) {
            return 0;
        }
        return (int) Math.ceil(this.f59415e.size() / 2.0d);
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
            cVar.f59423c = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f59424d = (TbImageView) view.findViewById(R.id.bottom_sticker);
            cVar.f59421a = (RelativeLayout) view.findViewById(R.id.top_container);
            cVar.f59427g = (ImageView) view.findViewById(R.id.no_sticker);
            cVar.f59422b = (RelativeLayout) view.findViewById(R.id.bottom_container);
            cVar.f59425e = (ProgressBar) view.findViewById(R.id.top_progressbar);
            cVar.f59426f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f59423c.setAutoChangeStyle(false);
        cVar.f59424d.setAutoChangeStyle(false);
        cVar.f59423c.setGifIconSupport(false);
        cVar.f59424d.setGifIconSupport(false);
        int i3 = i2 * 2;
        if (ListUtils.getItem(this.f59415e, i3) instanceof StickerItem) {
            cVar.f59421a.setVisibility(0);
            if (this.f59415e.get(i3).id == -1) {
                cVar.f59427g.setVisibility(0);
                cVar.f59423c.setVisibility(8);
                cVar.f59427g.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                cVar.f59427g.setVisibility(8);
                cVar.f59423c.setVisibility(0);
                cVar.f59423c.V(this.f59415e.get(i3).img, 10, true);
            }
            cVar.f59421a.setOnClickListener(new a(i2));
            if (this.f59415e.get(i3).isDownLoading) {
                cVar.f59425e.setVisibility(0);
            } else {
                cVar.f59425e.setVisibility(8);
            }
            if (this.f59415e.get(i3).isSelect) {
                SkinManager.setBackgroundResource(cVar.f59421a, R.drawable.bg_select_sticker);
            } else {
                cVar.f59421a.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f59421a.setVisibility(8);
        }
        int i4 = i3 + 1;
        if (ListUtils.getItem(this.f59415e, i4) instanceof StickerItem) {
            cVar.f59422b.setVisibility(0);
            cVar.f59424d.V(this.f59415e.get(i4).img, 10, true);
            cVar.f59422b.setOnClickListener(new b(i2));
            if (this.f59415e.get(i4).isDownLoading) {
                cVar.f59426f.setVisibility(0);
            } else {
                cVar.f59426f.setVisibility(8);
            }
            if (this.f59415e.get(i4).isSelect) {
                SkinManager.setBackgroundResource(cVar.f59422b, R.drawable.bg_select_sticker);
            } else {
                cVar.f59422b.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f59422b.setVisibility(8);
        }
        return view;
    }
}
