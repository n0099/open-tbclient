package d.b.i0.g1;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes4.dex */
public class d {
    public String A;
    public boolean B;
    public String D;
    public String E;
    public int F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public int L;
    public MetaData M;
    public String N;
    public boolean O;
    public ForumData P;
    public int Q;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f56104a;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ImageUrlData> f56106c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<AlaInfoData> f56107d;

    /* renamed from: e  reason: collision with root package name */
    public String f56108e;

    /* renamed from: f  reason: collision with root package name */
    public String f56109f;

    /* renamed from: g  reason: collision with root package name */
    public String f56110g;

    /* renamed from: h  reason: collision with root package name */
    public String f56111h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public String t;
    public String u;
    public int v;
    public String x;
    public String y;
    public boolean z;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f56105b = new HashMap<>();
    public boolean m = true;
    public a n = null;
    public int o = 0;
    public boolean p = false;
    public boolean q = false;
    public b r = null;
    public AdvertAppInfo s = null;
    public boolean w = false;
    public boolean C = false;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f56112a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f56113b;

        /* renamed from: c  reason: collision with root package name */
        public String f56114c;

        /* renamed from: d  reason: collision with root package name */
        public int f56115d;

        /* renamed from: e  reason: collision with root package name */
        public int f56116e;

        public a(String str, String str2, int i, int i2) {
            this.f56113b = null;
            this.f56114c = null;
            this.f56115d = 0;
            this.f56116e = 0;
            this.f56114c = str2;
            this.f56113b = str;
            this.f56115d = i;
            this.f56116e = i2;
        }

        public final void b() {
            this.f56112a.addPostData("forum_id", d.this.f56111h);
            this.f56112a.addPostData("user_id", d.this.t == null ? "0" : d.this.t);
            this.f56112a.addPostData("scr_w", String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
            this.f56112a.addPostData("scr_h", String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
            this.f56112a.addPostData("q_type", String.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
            this.f56112a.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            this.f56112a.addPostData("page_name", "PB");
            this.f56112a.addPostData("pic_index", String.valueOf(d.this.f56104a.size()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public g doInBackground(Object... objArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.f56112a = netWork;
            netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, d.this.i);
            this.f56112a.addPostData("tid", this.f56113b);
            String str = this.f56114c;
            if (str != null) {
                this.f56112a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
            }
            if (!TextUtils.isEmpty(d.this.f56108e) && !"0".equals(d.this.f56108e)) {
                this.f56112a.addPostData("post_id", d.this.f56108e);
            }
            this.f56112a.addPostData("source", String.valueOf(d.this.q ? 1 : 2));
            d.this.q = false;
            this.f56112a.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.f56115d));
            this.f56112a.addPostData("prev", String.valueOf(this.f56116e));
            this.f56112a.addPostData("not_see_lz", String.valueOf(!d.this.p ? 1 : 0));
            this.f56112a.addPostData("is_top_agree", String.valueOf(d.this.B ? 1 : 2));
            if (!d.this.m) {
                this.f56112a.addPostData(r.f7699a, String.valueOf(1));
            }
            if (!StringUtils.isNull(d.this.u, true)) {
                this.f56112a.addPostData("obj_type", d.this.u);
            } else {
                this.f56112a.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(d.this.x)) {
                if (System.currentTimeMillis() - d.b.h0.r.d0.b.j().l("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    d.this.x = d.b.h0.r.d0.b.j().p("applist_intalled_apk_ids", "");
                }
            }
            this.f56112a.addPostData("applist", d.this.x);
            String e2 = d.b.p.b.d(TbadkCoreApplication.getInst()).e();
            if (!TextUtils.isEmpty(e2)) {
                this.f56112a.addPostData("oaid", e2);
            }
            this.f56112a.addPostData("ad_ext_params", AdExtParam.a.b().a());
            b();
            this.f56112a.getNetContext().getRequest().mNeedBackgroundLogin = false;
            String postNetData = this.f56112a.postNetData();
            if (this.f56112a.getNetContext().getResponse().isRequestSuccess()) {
                g gVar = new g();
                gVar.l(postNetData, true);
                return gVar;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f56112a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            d.this.n = null;
            super.cancel(true);
        }

        public String d() {
            return this.f56114c;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r8v45, resolved type: com.baidu.tbadk.coreExtra.view.ImageUrlData */
        /* JADX DEBUG: Multi-variable search result rejected for r8v46, resolved type: com.baidu.tbadk.coreExtra.view.ImageUrlData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(g gVar) {
            ImageUrlData imageUrlData;
            boolean z;
            int i;
            boolean z2;
            AgreeData agreeData;
            String str;
            int i2;
            super.onPostExecute(gVar);
            if (d.this.f56106c == null) {
                return;
            }
            String str2 = null;
            d.this.n = null;
            if (gVar == null) {
                if (d.this.r != null) {
                    NetWork netWork = this.f56112a;
                    if (netWork != null) {
                        i2 = netWork.getServerErrorCode();
                        if (this.f56114c == null) {
                            str2 = this.f56112a.getErrorString();
                        }
                    } else {
                        i2 = -1;
                    }
                    d.this.r.b(i2, str2);
                    return;
                }
                return;
            }
            boolean isEmpty = ListUtils.isEmpty(gVar.g());
            if (d.this.z && !isEmpty) {
                d.this.f56104a.clear();
                d.this.f56106c.clear();
                d.this.f56105b.clear();
            }
            if (gVar.h() != 0) {
                d.this.o = gVar.h();
            }
            d.this.s = gVar.a();
            d.this.Q = gVar.n;
            d dVar = d.this;
            dVar.K = gVar.j;
            dVar.L = gVar.i();
            d dVar2 = d.this;
            dVar2.M = gVar.l;
            dVar2.N = gVar.k;
            dVar2.O = gVar.m == 1;
            if (this.f56114c == null) {
                d.this.f56104a.clear();
                d.this.f56105b.clear();
            }
            LinkedList<e> g2 = gVar.g();
            int size = g2.size();
            if (size <= 0) {
                imageUrlData = null;
                z = isEmpty;
                d.this.l = true;
            } else {
                int i3 = 0;
                while (i3 < size) {
                    e eVar = g2.get(i3);
                    String S = d.this.S(eVar);
                    ImageUrlData imageUrlData2 = new ImageUrlData();
                    String f2 = eVar.f();
                    imageUrlData2.id = f2;
                    if (StringHelper.equals(f2, d.this.A)) {
                        imageUrlData2.setSourceImageRectInScreen(d.this.y);
                    }
                    imageUrlData2.imageUrl = S;
                    String str3 = S + "*" + eVar.k();
                    imageUrlData2.urlType = 10;
                    imageUrlData2.originalUrl = eVar.i();
                    boolean z3 = isEmpty;
                    imageUrlData2.originalSize = eVar.j();
                    imageUrlData2.forumId = d.this.f56111h;
                    imageUrlData2.forumName = d.this.i;
                    imageUrlData2.threadId = d.b.c.e.m.b.f(this.f56113b, -1L);
                    imageUrlData2.nid = d.this.f56110g;
                    imageUrlData2.postId = d.b.c.e.m.b.f(eVar.c(), -1L);
                    imageUrlData2.userId = eVar.o();
                    imageUrlData2.userNameShow = StringUtils.isNull(eVar.q()) ? eVar.p() : eVar.q();
                    imageUrlData2.mIsReserver = d.this.m;
                    imageUrlData2.mIsSeeHost = d.this.p;
                    imageUrlData2.overAllIndex = eVar.k();
                    imageUrlData2.mThreadType = d.this.v;
                    imageUrlData2.mPicType = eVar.l();
                    imageUrlData2.mTagName = eVar.n();
                    imageUrlData2.mIsShowOrigonButton = eVar.v();
                    imageUrlData2.isLongPic = eVar.u();
                    imageUrlData2.isBlockedPic = eVar.s();
                    imageUrlData2.from = d.this.u;
                    if (eVar.m() != null) {
                        imageUrlData2.richTextArray = eVar.m().toString();
                    }
                    imageUrlData2.isFirstPost = eVar.t();
                    if (eVar.a() != null) {
                        AgreeData a2 = eVar.a();
                        imageUrlData2.agreeData = a2;
                        a2.isFromImageViewer = true;
                        a2.mImageViewerFromPage = d.this.u;
                        imageUrlData2.agreeData.forumId = d.this.f56111h;
                        imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                        AgreeData agreeData2 = imageUrlData2.agreeData;
                        agreeData2.nid = imageUrlData2.nid;
                        agreeData2.postId = String.valueOf(imageUrlData2.postId);
                        imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                        imageUrlData2.commentNum = eVar.d();
                        if (eVar.t()) {
                            AgreeData agreeData3 = imageUrlData2.agreeData;
                            agreeData3.objType = 3;
                            agreeData3.isInThread = true;
                            agreeData3.isInPost = false;
                        } else {
                            AgreeData agreeData4 = imageUrlData2.agreeData;
                            agreeData4.objType = 1;
                            agreeData4.isInThread = false;
                            agreeData4.isInPost = true;
                        }
                        imageUrlData2.agreeData.cardType = d.this.F;
                        imageUrlData2.agreeData.recomSource = d.this.G;
                        imageUrlData2.agreeData.recomAbTag = d.this.H;
                        imageUrlData2.agreeData.recomExtra = d.this.J;
                        imageUrlData2.agreeData.recomWeight = d.this.I;
                    }
                    if (d.this.f56105b.containsKey(imageUrlData2.id)) {
                        String str4 = (String) d.this.f56105b.get(imageUrlData2.id);
                        ImageUrlData imageUrlData3 = (ImageUrlData) d.this.f56106c.get(str4);
                        if (imageUrlData3 == null) {
                            d.this.f56106c.put(str4, imageUrlData2);
                        } else {
                            imageUrlData3.imageUrl = imageUrlData2.imageUrl;
                            imageUrlData3.overAllIndex = imageUrlData2.overAllIndex;
                            imageUrlData3.mIsShowOrigonButton = imageUrlData2.mIsShowOrigonButton;
                            imageUrlData3.isLongPic = imageUrlData2.isLongPic;
                            imageUrlData3.richTextArray = imageUrlData2.richTextArray;
                            imageUrlData3.commentNum = imageUrlData2.commentNum;
                            imageUrlData3.agreeData = imageUrlData2.agreeData;
                            imageUrlData3.isFirstPost = imageUrlData2.isFirstPost;
                            imageUrlData3.userId = imageUrlData2.userId;
                            imageUrlData3.userNameShow = imageUrlData2.userNameShow;
                            imageUrlData3.forumId = d.this.f56111h;
                            imageUrlData3.forumName = d.this.i;
                            if (StringHelper.equals(imageUrlData2.id, d.this.A)) {
                                imageUrlData3.setSourceImageRectInScreen(d.this.y);
                            }
                        }
                        str = null;
                    } else if (!d.this.C) {
                        str = null;
                        d.this.f56106c.put(str3, imageUrlData2);
                        if (d.this.w) {
                            d.this.f56104a.add(i3, str3);
                        } else {
                            d.this.f56104a.add(str3);
                        }
                        d.this.f56105b.put(imageUrlData2.id, str3);
                    } else {
                        d dVar3 = d.this;
                        dVar3.o = dVar3.f56106c.size();
                        str = null;
                        d.this.s = null;
                    }
                    i3++;
                    isEmpty = z3;
                    str2 = str;
                }
                String str5 = str2;
                z = isEmpty;
                e eVar2 = (e) ListUtils.getItem(g2, 0);
                if (eVar2 != null) {
                    d.this.j = eVar2.f();
                }
                e eVar3 = (e) ListUtils.getItem(g2, size - 1);
                imageUrlData = str5;
                if (eVar3 != null) {
                    d.this.k = eVar3.f();
                    d dVar4 = d.this;
                    dVar4.l = ((long) dVar4.o) == eVar3.k();
                    imageUrlData = str5;
                }
            }
            for (ImageUrlData imageUrlData4 : d.this.f56106c.values()) {
                if (imageUrlData4.agreeData == null) {
                    long j = imageUrlData4.postId;
                    if (imageUrlData == null) {
                        for (ImageUrlData imageUrlData5 : d.this.f56106c.values()) {
                            if (imageUrlData5.postId == j && (agreeData = imageUrlData5.agreeData) != null) {
                                imageUrlData4.agreeData = agreeData;
                                imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                imageUrlData4.commentNum = imageUrlData5.commentNum;
                                imageUrlData4.userId = imageUrlData5.userId;
                                imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                imageUrlData4.forumId = d.this.f56111h;
                                imageUrlData4.forumName = d.this.i;
                                imageUrlData = imageUrlData5;
                            }
                        }
                    } else if (j == imageUrlData.postId) {
                        imageUrlData4.agreeData = imageUrlData.agreeData;
                        imageUrlData4.richTextArray = imageUrlData.richTextArray;
                        imageUrlData4.commentNum = imageUrlData.commentNum;
                        imageUrlData4.userId = imageUrlData.userId;
                        imageUrlData4.userNameShow = imageUrlData.userNameShow;
                        imageUrlData4.forumId = d.this.f56111h;
                        imageUrlData4.forumName = d.this.i;
                    }
                }
            }
            if (this.f56114c == null) {
                d.this.f56109f = this.f56113b;
                i = 0;
                z2 = true;
            } else {
                i = -1;
                z2 = false;
            }
            int position = d.this.w ? ListUtils.getPosition(d.this.f56104a, (String) d.this.f56105b.get(this.f56114c)) - 1 : i;
            d.this.D = gVar.e();
            d.this.E = gVar.j();
            d.this.P = gVar.f();
            if (d.this.f56107d == null) {
                d.this.f56107d = new ArrayList();
                if (gVar.d() != null && gVar.g().size() > 0) {
                    d.this.f56107d.addAll(gVar.d());
                }
            }
            if (d.this.r != null) {
                d.this.r.a(d.this.f56104a, position, d.this.o, false, null, z2, d.this.s, z);
            }
            d.this.z = false;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i, String str);
    }

    public d(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.l = false;
        this.f56104a = arrayList;
        this.f56106c = map;
        if (arrayList == null) {
            this.f56104a = new ArrayList<>();
        }
        Iterator<String> it = this.f56104a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.f56105b.put(d.b.i0.g1.b.a(next), next);
        }
        this.f56109f = str3;
        this.f56110g = str4;
        this.i = str2;
        this.f56111h = str;
        this.k = str5;
        this.v = i;
        this.l = str5 == null;
        this.t = str6;
        this.u = str7;
        this.z = z;
        this.B = false;
        this.F = i2;
        this.G = str8;
        this.H = str9;
        this.I = str10;
        this.J = str11;
    }

    public final String S(e eVar) {
        if (eVar.b() != null && eVar.b().length() > 0) {
            return eVar.b();
        }
        StringBuilder sb = new StringBuilder(150);
        int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
        int i = threadImageMaxWidth * threadImageMaxWidth;
        if (eVar.e() * eVar.r() > i) {
            double sqrt = Math.sqrt(i / (eVar.e() * eVar.r()));
            sb.append(BigImageLoaderProc.NCDN_PER);
            sb.append(String.valueOf((int) (eVar.r() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (eVar.e() * sqrt)));
        } else {
            sb.append(BigImageLoaderProc.NCDN_PER);
            sb.append(String.valueOf(eVar.r()));
            sb.append("&height=");
            sb.append(String.valueOf(eVar.e()));
        }
        sb.append("&src=");
        sb.append(k.getUrlEncode(eVar.g()));
        return sb.toString();
    }

    public ArrayList<AlaInfoData> T() {
        return this.f56107d;
    }

    public String U() {
        return this.D;
    }

    public void V() {
        this.w = false;
        if (this.l) {
            return;
        }
        i0(this.f56109f, this.k, 10, 0);
    }

    public void W() {
        this.w = true;
        String str = this.f56104a.get(0);
        if (StringUtils.isNull(this.j)) {
            this.j = d.b.i0.g1.b.a(str);
        }
        i0(this.f56109f, this.j, 0, 10);
    }

    public String X() {
        return this.E;
    }

    public int Y() {
        return this.Q;
    }

    public void Z(String str) {
        this.A = str;
    }

    public void a0(boolean z) {
        this.q = z;
    }

    public void b0(boolean z) {
        this.C = z;
    }

    public void c0(boolean z) {
        this.B = z;
    }

    public void d0(b bVar) {
        this.r = bVar;
    }

    public void e0(String str) {
        this.f56108e = str;
    }

    public void f0(boolean z) {
        this.m = z;
    }

    public void g0(boolean z) {
        this.p = z;
    }

    public void h0(String str) {
        this.y = str;
    }

    public final void i0(String str, String str2, int i, int i2) {
        a aVar = this.n;
        if (aVar != null) {
            if (str2 != null && str2.equals(aVar.d())) {
                return;
            }
            this.n.cancel();
        }
        a aVar2 = new a(str, str2, i, i2);
        this.n = aVar2;
        aVar2.setPriority(3);
        this.n.execute(new Object[0]);
    }
}
