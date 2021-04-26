package d.a.j0.d2.o.n;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.j0.d2.h.e;
import d.a.j0.d2.h.f;
import d.a.j0.d2.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseVideoPBReplyFragment f52943a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPbFragment f52944b;

    /* renamed from: c  reason: collision with root package name */
    public int f52945c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52946d = false;

    /* renamed from: e  reason: collision with root package name */
    public final TbRichTextView.x f52947e = new a();

    /* renamed from: f  reason: collision with root package name */
    public c f52948f = new c(new C1196b());

    /* loaded from: classes3.dex */
    public class a implements TbRichTextView.x {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v13, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            d.a.j0.d2.o.o.a E0;
            try {
                StatisticItem statisticItem = new StatisticItem("c13398");
                statisticItem.param("tid", b.this.f52943a.z().O0());
                statisticItem.param("fid", b.this.f52943a.z().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_locate", 3);
                statisticItem.param("obj_type", z2 ? 1 : 2);
                TiebaStatic.log(statisticItem);
                TiebaStatic.eventStat(b.this.f52943a.getPageContext().getPageActivity(), "pic_pb", "");
                if (b.this.f52943a.z().y0().a0()) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    int i3 = -1;
                    if (view.getParent() instanceof TbRichTextView) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                        if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().w() != null) {
                            ArrayList<TbRichTextImageInfo> w = tbRichTextView.getRichText().w();
                            int i4 = -1;
                            for (int i5 = 0; i5 < w.size(); i5++) {
                                if (w.get(i5) != null) {
                                    arrayList.add(w.get(i5).x());
                                    if (i4 == -1 && str != null && str.equals(w.get(i5).x())) {
                                        i4 = i5;
                                    }
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    imageUrlData.imageUrl = w.get(i5).x();
                                    imageUrlData.originalUrl = w.get(i5).x();
                                    imageUrlData.isLongPic = w.get(i5).A();
                                    concurrentHashMap.put(w.get(i5).x(), imageUrlData);
                                }
                            }
                            i3 = i4;
                        }
                    }
                    ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                    bVar.x(arrayList);
                    bVar.B(i3);
                    bVar.C(false);
                    bVar.G(b.this.f52943a.z().J0());
                    bVar.w(concurrentHashMap);
                    bVar.I(true);
                    bVar.L(false);
                    if (b.this.f52943a.z() != null) {
                        bVar.H(b.this.f52943a.z().d0());
                        bVar.A(b.this.f52943a.z().getFromForumId());
                        if (b.this.f52943a.z().y0() != null) {
                            bVar.O(b.this.f52943a.z().y0().L());
                        }
                    }
                    ImageViewerConfig v = bVar.v(b.this.f52943a.getPageContext().getPageActivity());
                    v.getIntent().putExtra("from", "pb");
                    b.this.f52943a.sendMessage(new CustomMessage(2010000, v));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    return;
                }
                PbActivity.e eVar = new PbActivity.e();
                b.this.m(str, i2, eVar);
                if (eVar.f19660h) {
                    TbRichText p = b.this.p(str, i2);
                    if (p != null && b.this.f52945c >= 0 && b.this.f52945c < p.u().size()) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        String a2 = f.a(p.u().get(b.this.f52945c));
                        int i6 = 0;
                        while (true) {
                            if (i6 >= eVar.f19653a.size()) {
                                break;
                            } else if (eVar.f19653a.get(i6).equals(a2)) {
                                eVar.j = i6;
                                arrayList2.add(a2);
                                break;
                            } else {
                                i6++;
                            }
                        }
                        if (p.getPostId() != 0 && (E0 = b.this.f52943a.E0()) != null) {
                            ArrayList<n> a3 = E0.a();
                            if (ListUtils.getCount(a3) > 0) {
                                Iterator<n> it = a3.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    n next = it.next();
                                    if ((next instanceof PostData) && p.getPostId() == d.a.c.e.m.b.f(((PostData) next).E(), 0L)) {
                                        d.a.j0.d2.m.a.b(b.this.f52943a.z().y0(), (PostData) next, ((PostData) next).d0, 8, 3);
                                        break;
                                    }
                                }
                            }
                        }
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!ListUtils.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, eVar.f19654b.get(str2));
                        }
                        ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                        bVar2.x(arrayList2);
                        bVar2.z(eVar.f19655c);
                        bVar2.y(eVar.f19656d);
                        bVar2.P(eVar.f19657e);
                        bVar2.C(eVar.f19659g);
                        bVar2.I(true);
                        bVar2.K(eVar.f19661i);
                        bVar2.w(concurrentHashMap2);
                        bVar2.L(false);
                        bVar2.G(b.this.f52943a.z().J0());
                        bVar2.M(eVar.f19658f);
                        if (b.this.f52943a.z() != null) {
                            bVar2.H(b.this.f52943a.z().d0());
                            bVar2.A(b.this.f52943a.z().getFromForumId());
                            if (b.this.f52943a.z().y0() != null) {
                                bVar2.O(b.this.f52943a.z().y0().L());
                            }
                        }
                        ImageViewerConfig v2 = bVar2.v(b.this.f52943a.getPageContext().getPageActivity());
                        v2.getIntent().putExtra("from", "pb");
                        b.this.f52943a.sendMessage(new CustomMessage(2010000, v2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(ListUtils.getItem(eVar.f19653a, 0));
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                if (!ListUtils.isEmpty(arrayList3)) {
                    String str3 = (String) arrayList3.get(0);
                    concurrentHashMap3.put(str3, eVar.f19654b.get(str3));
                }
                ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                bVar3.x(arrayList3);
                bVar3.z(eVar.f19655c);
                bVar3.y(eVar.f19656d);
                bVar3.P(eVar.f19657e);
                bVar3.C(eVar.f19659g);
                bVar3.I(true);
                bVar3.K(eVar.f19653a.get(0));
                bVar3.w(concurrentHashMap3);
                bVar3.G(b.this.f52943a.z().J0());
                bVar3.L(false);
                bVar3.M(eVar.f19658f);
                bVar3.D(false);
                if (b.this.f52943a.z() != null) {
                    bVar3.H(b.this.f52943a.z().d0());
                    bVar3.A(b.this.f52943a.z().getFromForumId());
                    if (b.this.f52943a.z().y0() != null) {
                        bVar3.O(b.this.f52943a.z().y0().L());
                    }
                }
                ImageViewerConfig v3 = bVar3.v(b.this.f52943a.getPageContext().getPageActivity());
                v3.getIntent().putExtra("from", "pb");
                b.this.f52943a.sendMessage(new CustomMessage(2010000, v3));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* renamed from: d.a.j0.d2.o.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1196b implements c.a {
        public C1196b() {
        }

        @Override // d.a.j0.d2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // d.a.j0.d2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            VideoPbFragment videoPbFragment = b.this.f52944b;
            if (videoPbFragment != null && videoPbFragment.isAdded()) {
                if (view != null) {
                    if (view.getId() == R.id.richText) {
                        VideoPbFragment videoPbFragment2 = b.this.f52944b;
                        if (videoPbFragment2 != null && videoPbFragment2.m4(view)) {
                            return true;
                        }
                    } else if (view.getId() == R.id.pb_floor_item_layout) {
                        if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                            b.this.o((SparseArray) view.getTag(R.id.tag_from));
                        }
                    } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                        SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                        if (sparseArray == null) {
                            return false;
                        }
                        b.this.o(sparseArray);
                    }
                }
                VideoPbFragment videoPbFragment3 = b.this.f52944b;
                if (videoPbFragment3 != null) {
                    videoPbFragment3.U4();
                }
            }
            return true;
        }

        @Override // d.a.j0.d2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        this.f52943a = baseVideoPBReplyFragment;
        this.f52944b = baseVideoPBReplyFragment.w();
    }

    public final void d(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        if (eVar == null || eVar.Q() == null || eVar.Q().f52071a == null || (list = eVar.Q().f52071a) == null || arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list.size() <= 0 || arrayList.size() <= 0) {
            return;
        }
        arrayList3.addAll(list);
        Iterator<PostData> it = arrayList.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    PostData postData = (PostData) it2.next();
                    if (postData != null && !TextUtils.isEmpty(next.E()) && !TextUtils.isEmpty(postData.E()) && next.E().equals(postData.E())) {
                        arrayList2.add(postData);
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            arrayList3.removeAll(arrayList2);
        }
        if (arrayList3.size() > 0) {
            arrayList.addAll(arrayList3);
        }
    }

    public final TbRichText e(ArrayList<PostData> arrayList, String str, int i2) {
        ArrayList<TbRichTextData> u;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                TbRichText K = arrayList.get(i3).K();
                if (K != null && (u = K.u()) != null) {
                    int size = u.size();
                    int i4 = -1;
                    for (int i5 = 0; i5 < size; i5++) {
                        if (u.get(i5) != null && u.get(i5).getType() == 8) {
                            i4++;
                            if (u.get(i5).x().u().equals(str) || u.get(i5).x().v().equals(str)) {
                                int h2 = (int) l.h(TbadkCoreApplication.getInst());
                                int width = u.get(i5).x().getWidth() * h2;
                                int height = u.get(i5).x().getHeight() * h2;
                                if (width < 80 || height < 80 || width * height < 10000) {
                                    return null;
                                }
                                this.f52945c = i5;
                                return K;
                            } else if (i4 > i2) {
                                break;
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final int f(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo x;
        if (tbRichText == tbRichText2) {
            this.f52946d = true;
        }
        if (tbRichText != null) {
            int size = tbRichText.u().size();
            int i4 = i2;
            int i5 = -1;
            for (int i6 = 0; i6 < size; i6++) {
                TbRichTextData tbRichTextData = tbRichText.u().get(i6);
                if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                    i5++;
                    int h2 = (int) l.h(TbadkCoreApplication.getInst());
                    int width = tbRichTextData.x().getWidth() * h2;
                    int height = tbRichTextData.x().getHeight() * h2;
                    if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.x().z()) {
                        if (tbRichText == tbRichText2) {
                            if (i5 <= i3) {
                                i4--;
                            }
                        }
                    } else if (tbRichTextData.getType() != 20) {
                        String a2 = f.a(tbRichTextData);
                        if (!TextUtils.isEmpty(a2)) {
                            arrayList.add(a2);
                            if (tbRichTextData != null && (x = tbRichTextData.x()) != null) {
                                String u = x.u();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                    imageUrlData.urlType = 38;
                                    u = x.v();
                                } else {
                                    imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.f52943a.A()).get(VideoPbViewModel.class)).l() ? 17 : 18;
                                }
                                imageUrlData.imageUrl = u;
                                imageUrlData.originalUrl = j(tbRichTextData);
                                imageUrlData.originalSize = k(tbRichTextData);
                                imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
                                imageUrlData.isLongPic = g(tbRichTextData);
                                imageUrlData.postId = tbRichText.getPostId();
                                imageUrlData.threadId = d.a.c.e.m.b.f(this.f52943a.z().O0(), -1L);
                                imageUrlData.mIsReserver = this.f52943a.z().J0();
                                imageUrlData.mIsSeeHost = this.f52943a.z().d0();
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(a2, imageUrlData);
                                }
                            }
                        }
                        if (!this.f52946d) {
                            i4++;
                        }
                    }
                }
            }
            return i4;
        }
        return i2;
    }

    public final boolean g(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return false;
        }
        return tbRichTextData.x().A();
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return false;
        }
        return tbRichTextData.x().B();
    }

    public TbRichTextView.x i() {
        return this.f52947e;
    }

    public final String j(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return null;
        }
        return tbRichTextData.x().w();
    }

    public final long k(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.x() == null) {
            return 0L;
        }
        return tbRichTextData.x().getOriginalSize();
    }

    public c l() {
        return this.f52948f;
    }

    public void m(String str, int i2, PbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        if (eVar == null) {
            return;
        }
        e y0 = this.f52943a.z().y0();
        TbRichText p = p(str, i2);
        if (p == null || (tbRichTextData = p.u().get(this.f52945c)) == null) {
            return;
        }
        eVar.f19658f = String.valueOf(p.getPostId());
        eVar.f19653a = new ArrayList<>();
        eVar.f19654b = new ConcurrentHashMap<>();
        if (!tbRichTextData.x().z()) {
            eVar.f19660h = false;
            String a2 = f.a(tbRichTextData);
            eVar.f19653a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.f52943a.A()).get(VideoPbViewModel.class)).l() ? 17 : 18;
            }
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalSize = k(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
            imageUrlData.isLongPic = g(tbRichTextData);
            imageUrlData.postId = p.getPostId();
            imageUrlData.mIsReserver = this.f52943a.z().J0();
            imageUrlData.mIsSeeHost = this.f52943a.z().d0();
            eVar.f19654b.put(a2, imageUrlData);
            if (y0 != null) {
                if (y0.l() != null) {
                    eVar.f19655c = y0.l().getName();
                    eVar.f19656d = y0.l().getId();
                }
                if (y0.L() != null) {
                    eVar.f19657e = y0.L().o0();
                }
                eVar.f19659g = y0.s() == 1;
            }
            imageUrlData.threadId = d.a.c.e.m.b.f(eVar.f19657e, -1L);
            return;
        }
        eVar.f19660h = true;
        int size = y0.D().size();
        this.f52946d = false;
        eVar.j = -1;
        int f2 = y0.j() != null ? f(y0.j().K(), p, i2, i2, eVar.f19653a, eVar.f19654b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = y0.D().get(i3);
            if (postData.E() == null || y0.j() == null || y0.j().E() == null || !postData.E().equals(y0.j().E())) {
                f2 = f(postData.K(), p, f2, i2, eVar.f19653a, eVar.f19654b);
            }
        }
        if (eVar.f19653a.size() > 0) {
            ArrayList<String> arrayList = eVar.f19653a;
            eVar.f19661i = arrayList.get(arrayList.size() - 1);
        }
        if (y0 != null) {
            if (y0.l() != null) {
                eVar.f19655c = y0.l().getName();
                eVar.f19656d = y0.l().getId();
            }
            if (y0.L() != null) {
                eVar.f19657e = y0.L().o0();
            }
            eVar.f19659g = y0.s() == 1;
        }
        eVar.j = f2;
    }

    public PbActivity.e n(String str) {
        String str2 = null;
        if (this.f52943a.z() != null && this.f52943a.z().y0() != null && this.f52943a.z().y0().D() != null && this.f52943a.z().y0().D().size() != 0 && !StringUtils.isNull(str)) {
            PbActivity.e eVar = new PbActivity.e();
            int i2 = 0;
            while (true) {
                if (i2 >= this.f52943a.z().y0().D().size()) {
                    i2 = 0;
                    break;
                } else if (str.equals(this.f52943a.z().y0().D().get(i2).E())) {
                    break;
                } else {
                    i2++;
                }
            }
            PostData postData = this.f52943a.z().y0().D().get(i2);
            if (postData.K() != null && postData.K().u() != null) {
                Iterator<TbRichTextData> it = postData.K().u().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        if (next.x() != null) {
                            str2 = next.x().u();
                        }
                    }
                }
                m(str2, 0, eVar);
                f.b(postData, eVar);
                return eVar;
            }
        }
        return null;
    }

    public final void o(SparseArray<Object> sparseArray) {
        PostData postData;
        if (!this.f52943a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null || this.f52943a.z() == null || this.f52943a.z().y0() == null || postData.A() == 1) {
            return;
        }
        String O0 = this.f52943a.z().O0();
        String E = postData.E();
        int S = this.f52943a.z().y0() != null ? this.f52943a.z().y0().S() : 0;
        PbActivity.e n = n(E);
        if (n == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f52943a.getPageContext().getPageActivity()).createSubPbActivityConfig(O0, E, "pb", true, null, false, null, S, postData.O(), this.f52943a.z().y0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null).addBigImageData(n.f19653a, n.f19654b, n.f19659g, n.j);
        addBigImageData.setKeyPageStartFrom(this.f52943a.z().x0());
        addBigImageData.setFromFrsForumId(this.f52943a.z().getFromForumId());
        addBigImageData.setKeyFromForumId(this.f52943a.z().getForumId());
        addBigImageData.setBjhData(this.f52943a.z().T());
        this.f52943a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText p(String str, int i2) {
        TbRichText tbRichText = null;
        if (this.f52943a.z() == null || this.f52943a.z().y0() == null || str == null || i2 < 0) {
            return null;
        }
        e y0 = this.f52943a.z().y0();
        if (y0.j() != null) {
            ArrayList<PostData> arrayList = new ArrayList<>();
            arrayList.add(y0.j());
            tbRichText = e(arrayList, str, i2);
        }
        if (tbRichText == null) {
            ArrayList<PostData> D = y0.D();
            d(y0, D);
            return e(D, str, i2);
        }
        return tbRichText;
    }
}
