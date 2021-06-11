package d.a.n0.e2.k.e.b1;

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
import d.a.m0.s.c.v;
import d.a.n0.e2.k.e.b1.b;
import java.util.List;
/* loaded from: classes5.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1315b, EmotionView.c {

    /* renamed from: e  reason: collision with root package name */
    public f f56826e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f56827f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f56828g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.e2.k.e.b1.b f56829h;

    /* renamed from: i  reason: collision with root package name */
    public QueryMatchEmotionModel f56830i;
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
            c.this.f56828g.setVisibility(8);
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

    /* renamed from: d.a.n0.e2.k.e.b1.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1316c implements GetEmotionPidModel.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f56833a;

        public C1316c(EmotionImageData emotionImageData) {
            this.f56833a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.a.m0.b0.c cVar) {
            if (cVar == null || TextUtils.isEmpty(cVar.f52584a)) {
                return;
            }
            this.f56833a.setPicId(cVar.f52584a);
            c.this.n(this.f56833a);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
        }
    }

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        this.f56826e = fVar;
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
            HListView hListView = this.f56828g;
            if (hListView == null || hListView.getParent() == null) {
                HListView hListView2 = new HListView(this.f56826e.getContext());
                this.f56828g = hListView2;
                SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                this.f56828g.setDividerWidth(l.g(this.f56826e.getPageActivity(), R.dimen.ds7));
                this.f56828g.setClipToPadding(false);
                int g2 = l.g(this.f56826e.getPageActivity(), R.dimen.ds10);
                this.f56828g.setPadding(g2, g2, g2, g2);
                this.f56828g.setSelector(R.drawable.list_selector_transparent);
                this.m.height = l.g(this.f56826e.getPageActivity(), R.dimen.ds136);
                this.l.addView(this.f56828g, this.m);
                if (this.f56829h == null) {
                    d.a.n0.e2.k.e.b1.b bVar = new d.a.n0.e2.k.e.b1.b();
                    this.f56829h = bVar;
                    bVar.d(this);
                    this.f56829h.c(this);
                    this.f56828g.setAdapter((ListAdapter) this.f56829h);
                    this.f56828g.setOnScrollListener(new b());
                }
            }
            this.f56828g.setVisibility(0);
            this.f56829h.b(list);
            this.f56829h.notifyDataSetChanged();
            this.f56828g.setSelection(0);
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

    @Override // d.a.n0.e2.k.e.b1.b.InterfaceC1315b
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
        this.o.x(emotionImageData.getPicUrl(), new C1316c(emotionImageData));
    }

    public void l() {
        QueryMatchEmotionModel queryMatchEmotionModel = this.f56830i;
        if (queryMatchEmotionModel != null) {
            queryMatchEmotionModel.cancelLoadData();
        }
    }

    public void m() {
        HListView hListView = this.f56828g;
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
        vVar.k("#(meme,net_" + Uri.encode(emotionImageData.getPicUrl()) + "," + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX);
        vVar.n(EmotionGroupType.NET_SUG);
        vVar.p(emotionImageData.getWidth());
        vVar.j(emotionImageData.getHeight());
        vVar.o(emotionImageData.getPicUrl());
        this.n.A(new d.a.m0.w.a(24, -1, vVar));
    }

    public final void o(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.j)) {
            return;
        }
        this.j = str;
        if (this.f56830i == null) {
            this.f56830i = new QueryMatchEmotionModel(this.f56826e);
        }
        this.f56830i.z(str, this);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i2, String str) {
    }

    public void p(String str) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f56827f) || !this.f56827f.contains(str)) {
            return;
        }
        o(str);
    }

    public void q(List<String> list) {
        this.f56827f = list;
    }

    public void r(EditorTools editorTools) {
        this.n = editorTools;
    }
}
