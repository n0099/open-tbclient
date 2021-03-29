package d.b.i0.c2.k.e.y0;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.GetEmotionPidModel;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel;
import d.b.b.a.f;
import d.b.b.e.p.l;
import d.b.b.e.p.q;
import d.b.h0.s.c.t;
import d.b.i0.c2.k.e.y0.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1159b, EmotionView.c {

    /* renamed from: e  reason: collision with root package name */
    public f f52943e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f52944f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f52945g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.c2.k.e.y0.b f52946h;
    public QueryMatchEmotionModel i;
    public String j;
    public ViewGroup l;
    public ViewGroup.LayoutParams m;
    public EditorTools n;
    public GetEmotionPidModel o;
    public Runnable p = new a();
    public Handler k = new Handler();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.j = "";
            c.this.f52945g.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsHListView.i {
        public b() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i, int i2, int i3) {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i) {
            if (i == 0) {
                c.this.k.removeCallbacks(c.this.p);
                c.this.k.postDelayed(c.this.p, 5000L);
            } else if (i != 1) {
            } else {
                c.this.k.removeCallbacks(c.this.p);
            }
        }
    }

    /* renamed from: d.b.i0.c2.k.e.y0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1160c implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f52949a;

        public C1160c(EmotionImageData emotionImageData) {
            this.f52949a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.b.h0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f49774a)) {
                return;
            }
            this.f52949a.setPicId(cVar.f49774a);
            c.this.n(this.f52949a);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i, String str) {
        }
    }

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.f52943e = fVar;
        this.l = viewGroup;
        this.m = layoutParams;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean a() {
        return true;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void b(String str, List<EmotionImageData> list) {
        if (TextUtils.isEmpty(str) || !str.equals(this.j)) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.j = "";
        } else if (this.l == null || this.m == null) {
        } else {
            if (list.size() > 10) {
                list = list.subList(0, 10);
            }
            TiebaStatic.log("c12488");
            HListView hListView = this.f52945g;
            if (hListView == null || hListView.getParent() == null) {
                HListView hListView2 = new HListView(this.f52943e.getContext());
                this.f52945g = hListView2;
                SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                this.f52945g.setDividerWidth(l.g(this.f52943e.getPageActivity(), R.dimen.ds7));
                this.f52945g.setClipToPadding(false);
                int g2 = l.g(this.f52943e.getPageActivity(), R.dimen.ds10);
                this.f52945g.setPadding(g2, g2, g2, g2);
                this.f52945g.setSelector(R.drawable.list_selector_transparent);
                this.m.height = l.g(this.f52943e.getPageActivity(), R.dimen.ds136);
                this.l.addView(this.f52945g, this.m);
                if (this.f52946h == null) {
                    d.b.i0.c2.k.e.y0.b bVar = new d.b.i0.c2.k.e.y0.b();
                    this.f52946h = bVar;
                    bVar.d(this);
                    this.f52946h.c(this);
                    this.f52945g.setAdapter((ListAdapter) this.f52946h);
                    this.f52945g.setOnScrollListener(new b());
                }
            }
            this.f52945g.setVisibility(0);
            this.f52946h.b(list);
            this.f52946h.notifyDataSetChanged();
            this.f52945g.setSelection(0);
            this.k.removeCallbacks(this.p);
            this.k.postDelayed(this.p, 5000L);
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void c() {
        this.k.removeCallbacks(this.p);
        this.k.postDelayed(this.p, 5000L);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean d() {
        return true;
    }

    @Override // d.b.i0.c2.k.e.y0.b.InterfaceC1159b
    public void e(EmotionImageData emotionImageData) {
        this.k.removeCallbacks(this.p);
        this.k.postDelayed(this.p, 5000L);
        if (emotionImageData == null || TextUtils.isEmpty(emotionImageData.getPicUrl()) || this.n == null) {
            return;
        }
        if (!TextUtils.isEmpty(emotionImageData.getPicId()) && !emotionImageData.getPicId().equals("0")) {
            n(emotionImageData);
            return;
        }
        if (this.o == null) {
            this.o = new GetEmotionPidModel();
        }
        this.o.t(emotionImageData.getPicUrl(), new C1160c(emotionImageData));
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void f() {
        this.k.removeCallbacks(this.p);
    }

    public void l() {
        QueryMatchEmotionModel queryMatchEmotionModel = this.i;
        if (queryMatchEmotionModel != null) {
            queryMatchEmotionModel.cancelLoadData();
        }
    }

    public void m() {
        HListView hListView = this.f52945g;
        if (hListView != null) {
            hListView.setVisibility(8);
        }
        this.k.removeCallbacks(this.p);
        this.j = "";
    }

    public final void n(EmotionImageData emotionImageData) {
        TiebaStatic.log("c12489");
        t tVar = new t();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String lowerCase = q.c(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT + sb.toString() + "7S6wbXjEKL9N").toLowerCase();
        tVar.i("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
        tVar.l(EmotionGroupType.NET_SUG);
        tVar.n(emotionImageData.getWidth());
        tVar.h(emotionImageData.getHeight());
        tVar.m(emotionImageData.getPicUrl());
        this.n.A(new d.b.h0.w.a(24, -1, tVar));
    }

    public final void o(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.j)) {
            return;
        }
        this.j = str;
        if (this.i == null) {
            this.i = new QueryMatchEmotionModel(this.f52943e);
        }
        this.i.v(str, this);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i, String str) {
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f52944f) || !this.f52944f.contains(str)) {
            return;
        }
        o(str);
    }

    public void q(List<String> list) {
        this.f52944f = list;
    }

    public void r(EditorTools editorTools) {
        this.n = editorTools;
    }
}
