package d.b.i0.d2.k.e.a1;

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
import d.b.c.a.f;
import d.b.c.e.p.l;
import d.b.c.e.p.q;
import d.b.h0.s.c.v;
import d.b.i0.d2.k.e.a1.b;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1206b, EmotionView.c {

    /* renamed from: e  reason: collision with root package name */
    public f f53970e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f53971f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f53972g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.d2.k.e.a1.b f53973h;
    public QueryMatchEmotionModel i;
    public String j;
    public ViewGroup l;
    public ViewGroup.LayoutParams m;
    public EditorTools n;
    public GetEmotionPidModel o;
    public Runnable p = new a();
    public Handler k = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.j = "";
            c.this.f53972g.setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
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

    /* renamed from: d.b.i0.d2.k.e.a1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1207c implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f53976a;

        public C1207c(EmotionImageData emotionImageData) {
            this.f53976a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.b.h0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f50167a)) {
                return;
            }
            this.f53976a.setPicId(cVar.f50167a);
            c.this.n(this.f53976a);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i, String str) {
        }
    }

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.f53970e = fVar;
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
            HListView hListView = this.f53972g;
            if (hListView == null || hListView.getParent() == null) {
                HListView hListView2 = new HListView(this.f53970e.getContext());
                this.f53972g = hListView2;
                SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                this.f53972g.setDividerWidth(l.g(this.f53970e.getPageActivity(), R.dimen.ds7));
                this.f53972g.setClipToPadding(false);
                int g2 = l.g(this.f53970e.getPageActivity(), R.dimen.ds10);
                this.f53972g.setPadding(g2, g2, g2, g2);
                this.f53972g.setSelector(R.drawable.list_selector_transparent);
                this.m.height = l.g(this.f53970e.getPageActivity(), R.dimen.ds136);
                this.l.addView(this.f53972g, this.m);
                if (this.f53973h == null) {
                    d.b.i0.d2.k.e.a1.b bVar = new d.b.i0.d2.k.e.a1.b();
                    this.f53973h = bVar;
                    bVar.d(this);
                    this.f53973h.c(this);
                    this.f53972g.setAdapter((ListAdapter) this.f53973h);
                    this.f53972g.setOnScrollListener(new b());
                }
            }
            this.f53972g.setVisibility(0);
            this.f53973h.b(list);
            this.f53973h.notifyDataSetChanged();
            this.f53972g.setSelection(0);
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

    @Override // d.b.i0.d2.k.e.a1.b.InterfaceC1206b
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
        this.o.t(emotionImageData.getPicUrl(), new C1207c(emotionImageData));
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
        HListView hListView = this.f53972g;
        if (hListView != null) {
            hListView.setVisibility(8);
        }
        this.k.removeCallbacks(this.p);
        this.j = "";
    }

    public final void n(EmotionImageData emotionImageData) {
        TiebaStatic.log("c12489");
        v vVar = new v();
        StringBuilder sb = new StringBuilder();
        sb.append(emotionImageData.getPicId());
        sb.append(",");
        sb.append(emotionImageData.getWidth());
        sb.append(",");
        sb.append(emotionImageData.getHeight());
        sb.append(",");
        String lowerCase = q.c(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT + sb.toString() + "7S6wbXjEKL9N").toLowerCase();
        vVar.i("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
        vVar.l(EmotionGroupType.NET_SUG);
        vVar.n(emotionImageData.getWidth());
        vVar.h(emotionImageData.getHeight());
        vVar.m(emotionImageData.getPicUrl());
        this.n.A(new d.b.h0.w.a(24, -1, vVar));
    }

    public final void o(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.j)) {
            return;
        }
        this.j = str;
        if (this.i == null) {
            this.i = new QueryMatchEmotionModel(this.f53970e);
        }
        this.i.v(str, this);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i, String str) {
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f53971f) || !this.f53971f.contains(str)) {
            return;
        }
        o(str);
    }

    public void q(List<String> list) {
        this.f53971f = list;
    }

    public void r(EditorTools editorTools) {
        this.n = editorTools;
    }
}
