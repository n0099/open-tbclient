package d.a.k0.d2.k.e.a1;

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
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.c.e.p.q;
import d.a.j0.s.c.v;
import d.a.k0.d2.k.e.a1.b;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1240b, EmotionView.c {

    /* renamed from: e  reason: collision with root package name */
    public f f52880e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f52881f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f52882g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.d2.k.e.a1.b f52883h;

    /* renamed from: i  reason: collision with root package name */
    public QueryMatchEmotionModel f52884i;
    public String j;
    public ViewGroup l;
    public ViewGroup.LayoutParams m;
    public EditorTools n;
    public GetEmotionPidModel o;
    public Runnable p = new a();
    public Handler k = new Handler();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.j = "";
            c.this.f52882g.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsHListView.i {
        public b() {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
            if (i2 == 0) {
                c.this.k.removeCallbacks(c.this.p);
                c.this.k.postDelayed(c.this.p, 5000L);
            } else if (i2 != 1) {
            } else {
                c.this.k.removeCallbacks(c.this.p);
            }
        }
    }

    /* renamed from: d.a.k0.d2.k.e.a1.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1241c implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f52887a;

        public C1241c(EmotionImageData emotionImageData) {
            this.f52887a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.a.j0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f48885a)) {
                return;
            }
            this.f52887a.setPicId(cVar.f48885a);
            c.this.n(this.f52887a);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
        }
    }

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.f52880e = fVar;
        this.l = viewGroup;
        this.m = layoutParams;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void a(String str, List<EmotionImageData> list) {
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
            HListView hListView = this.f52882g;
            if (hListView == null || hListView.getParent() == null) {
                HListView hListView2 = new HListView(this.f52880e.getContext());
                this.f52882g = hListView2;
                SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                this.f52882g.setDividerWidth(l.g(this.f52880e.getPageActivity(), R.dimen.ds7));
                this.f52882g.setClipToPadding(false);
                int g2 = l.g(this.f52880e.getPageActivity(), R.dimen.ds10);
                this.f52882g.setPadding(g2, g2, g2, g2);
                this.f52882g.setSelector(R.drawable.list_selector_transparent);
                this.m.height = l.g(this.f52880e.getPageActivity(), R.dimen.ds136);
                this.l.addView(this.f52882g, this.m);
                if (this.f52883h == null) {
                    d.a.k0.d2.k.e.a1.b bVar = new d.a.k0.d2.k.e.a1.b();
                    this.f52883h = bVar;
                    bVar.d(this);
                    this.f52883h.c(this);
                    this.f52882g.setAdapter((ListAdapter) this.f52883h);
                    this.f52882g.setOnScrollListener(new b());
                }
            }
            this.f52882g.setVisibility(0);
            this.f52883h.b(list);
            this.f52883h.notifyDataSetChanged();
            this.f52882g.setSelection(0);
            this.k.removeCallbacks(this.p);
            this.k.postDelayed(this.p, 5000L);
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void b() {
        this.k.removeCallbacks(this.p);
        this.k.postDelayed(this.p, 5000L);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean c() {
        return true;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void d() {
        this.k.removeCallbacks(this.p);
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean e() {
        return true;
    }

    @Override // d.a.k0.d2.k.e.a1.b.InterfaceC1240b
    public void f(EmotionImageData emotionImageData) {
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
        this.o.t(emotionImageData.getPicUrl(), new C1241c(emotionImageData));
    }

    public void l() {
        QueryMatchEmotionModel queryMatchEmotionModel = this.f52884i;
        if (queryMatchEmotionModel != null) {
            queryMatchEmotionModel.cancelLoadData();
        }
    }

    public void m() {
        HListView hListView = this.f52882g;
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
        this.n.A(new d.a.j0.w.a(24, -1, vVar));
    }

    public final void o(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.j)) {
            return;
        }
        this.j = str;
        if (this.f52884i == null) {
            this.f52884i = new QueryMatchEmotionModel(this.f52880e);
        }
        this.f52884i.v(str, this);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i2, String str) {
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f52881f) || !this.f52881f.contains(str)) {
            return;
        }
        o(str);
    }

    public void q(List<String> list) {
        this.f52881f = list;
    }

    public void r(EditorTools editorTools) {
        this.n = editorTools;
    }
}
