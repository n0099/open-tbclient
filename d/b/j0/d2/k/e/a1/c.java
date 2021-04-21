package d.b.j0.d2.k.e.a1;

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
import d.b.i0.s.c.v;
import d.b.j0.d2.k.e.a1.b;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1229b, EmotionView.c {

    /* renamed from: e  reason: collision with root package name */
    public f f54391e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f54392f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f54393g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.d2.k.e.a1.b f54394h;
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
            c.this.f54393g.setVisibility(8);
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

    /* renamed from: d.b.j0.d2.k.e.a1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1230c implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f54397a;

        public C1230c(EmotionImageData emotionImageData) {
            this.f54397a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.b.i0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f50503a)) {
                return;
            }
            this.f54397a.setPicId(cVar.f50503a);
            c.this.n(this.f54397a);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i, String str) {
        }
    }

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.f54391e = fVar;
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
            HListView hListView = this.f54393g;
            if (hListView == null || hListView.getParent() == null) {
                HListView hListView2 = new HListView(this.f54391e.getContext());
                this.f54393g = hListView2;
                SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                this.f54393g.setDividerWidth(l.g(this.f54391e.getPageActivity(), R.dimen.ds7));
                this.f54393g.setClipToPadding(false);
                int g2 = l.g(this.f54391e.getPageActivity(), R.dimen.ds10);
                this.f54393g.setPadding(g2, g2, g2, g2);
                this.f54393g.setSelector(R.drawable.list_selector_transparent);
                this.m.height = l.g(this.f54391e.getPageActivity(), R.dimen.ds136);
                this.l.addView(this.f54393g, this.m);
                if (this.f54394h == null) {
                    d.b.j0.d2.k.e.a1.b bVar = new d.b.j0.d2.k.e.a1.b();
                    this.f54394h = bVar;
                    bVar.d(this);
                    this.f54394h.c(this);
                    this.f54393g.setAdapter((ListAdapter) this.f54394h);
                    this.f54393g.setOnScrollListener(new b());
                }
            }
            this.f54393g.setVisibility(0);
            this.f54394h.b(list);
            this.f54394h.notifyDataSetChanged();
            this.f54393g.setSelection(0);
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

    @Override // d.b.j0.d2.k.e.a1.b.InterfaceC1229b
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
        this.o.t(emotionImageData.getPicUrl(), new C1230c(emotionImageData));
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
        HListView hListView = this.f54393g;
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
        this.n.A(new d.b.i0.w.a(24, -1, vVar));
    }

    public final void o(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.j)) {
            return;
        }
        this.j = str;
        if (this.i == null) {
            this.i = new QueryMatchEmotionModel(this.f54391e);
        }
        this.i.v(str, this);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i, String str) {
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f54392f) || !this.f54392f.contains(str)) {
            return;
        }
        o(str);
    }

    public void q(List<String> list) {
        this.f54392f = list;
    }

    public void r(EditorTools editorTools) {
        this.n = editorTools;
    }
}
