package d.b.j0.q3.m;

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
    public List<StickerItem> f61274e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f61275f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f61276e;

        public a(int i) {
            this.f61276e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f61274e.get(this.f61276e * 2)).isSelect || k.this.f61275f == null) {
                return;
            }
            k.this.f61275f.onStickerChoosed((StickerItem) k.this.f61274e.get(this.f61276e * 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f61278e;

        public b(int i) {
            this.f61278e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((StickerItem) k.this.f61274e.get((this.f61278e * 2) + 1)).isSelect || k.this.f61275f == null) {
                return;
            }
            k.this.f61275f.onStickerChoosed((StickerItem) k.this.f61274e.get((this.f61278e * 2) + 1));
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f61280a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f61281b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f61282c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f61283d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f61284e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f61285f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f61286g;

        public c(k kVar) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i) {
        return (StickerItem) ListUtils.getItem(this.f61274e, i);
    }

    public void d(List<StickerItem> list) {
        this.f61274e = list;
    }

    public void e(VideoEffectLayout.h hVar) {
        this.f61275f = hVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f61274e)) {
            return 0;
        }
        return (int) Math.ceil(this.f61274e.size() / 2.0d);
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
            cVar.f61282c = (TbImageView) view.findViewById(R.id.top_sticker);
            cVar.f61283d = (TbImageView) view.findViewById(R.id.bottom_sticker);
            cVar.f61280a = (RelativeLayout) view.findViewById(R.id.top_container);
            cVar.f61286g = (ImageView) view.findViewById(R.id.no_sticker);
            cVar.f61281b = (RelativeLayout) view.findViewById(R.id.bottom_container);
            cVar.f61284e = (ProgressBar) view.findViewById(R.id.top_progressbar);
            cVar.f61285f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.f61282c.setAutoChangeStyle(false);
        cVar.f61283d.setAutoChangeStyle(false);
        cVar.f61282c.setGifIconSupport(false);
        cVar.f61283d.setGifIconSupport(false);
        int i2 = i * 2;
        if (ListUtils.getItem(this.f61274e, i2) instanceof StickerItem) {
            cVar.f61280a.setVisibility(0);
            if (this.f61274e.get(i2).id == -1) {
                cVar.f61286g.setVisibility(0);
                cVar.f61282c.setVisibility(8);
                cVar.f61286g.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                cVar.f61286g.setVisibility(8);
                cVar.f61282c.setVisibility(0);
                cVar.f61282c.W(this.f61274e.get(i2).img, 10, true);
            }
            cVar.f61280a.setOnClickListener(new a(i));
            if (this.f61274e.get(i2).isDownLoading) {
                cVar.f61284e.setVisibility(0);
            } else {
                cVar.f61284e.setVisibility(8);
            }
            if (this.f61274e.get(i2).isSelect) {
                SkinManager.setBackgroundResource(cVar.f61280a, R.drawable.bg_select_sticker);
            } else {
                cVar.f61280a.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f61280a.setVisibility(8);
        }
        int i3 = i2 + 1;
        if (ListUtils.getItem(this.f61274e, i3) instanceof StickerItem) {
            cVar.f61281b.setVisibility(0);
            cVar.f61283d.W(this.f61274e.get(i3).img, 10, true);
            cVar.f61281b.setOnClickListener(new b(i));
            if (this.f61274e.get(i3).isDownLoading) {
                cVar.f61285f.setVisibility(0);
            } else {
                cVar.f61285f.setVisibility(8);
            }
            if (this.f61274e.get(i3).isSelect) {
                SkinManager.setBackgroundResource(cVar.f61281b, R.drawable.bg_select_sticker);
            } else {
                cVar.f61281b.setBackgroundResource(R.color.transparent);
            }
        } else {
            cVar.f61281b.setVisibility(8);
        }
        return view;
    }
}
