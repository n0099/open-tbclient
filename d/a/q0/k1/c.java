package d.a.q0.k1;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public boolean C;
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
    public ArrayList<String> f59854a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f59855b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ImageUrlData> f59856c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<AlaInfoData> f59857d;

    /* renamed from: e  reason: collision with root package name */
    public String f59858e;

    /* renamed from: f  reason: collision with root package name */
    public String f59859f;

    /* renamed from: g  reason: collision with root package name */
    public String f59860g;

    /* renamed from: h  reason: collision with root package name */
    public String f59861h;

    /* renamed from: i  reason: collision with root package name */
    public String f59862i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public a n;
    public int o;
    public boolean p;
    public boolean q;
    public b r;
    public AdvertAppInfo s;
    public String t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f59863a;

        /* renamed from: b  reason: collision with root package name */
        public String f59864b;

        /* renamed from: c  reason: collision with root package name */
        public String f59865c;

        /* renamed from: d  reason: collision with root package name */
        public int f59866d;

        /* renamed from: e  reason: collision with root package name */
        public int f59867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f59868f;

        public a(c cVar, String str, String str2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59868f = cVar;
            this.f59863a = null;
            this.f59864b = null;
            this.f59865c = null;
            this.f59866d = 0;
            this.f59867e = 0;
            this.f59865c = str2;
            this.f59864b = str;
            this.f59866d = i2;
            this.f59867e = i3;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59863a.addPostData("forum_id", this.f59868f.f59861h);
                this.f59863a.addPostData("user_id", this.f59868f.t == null ? "0" : this.f59868f.t);
                this.f59863a.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                this.f59863a.addPostData("scr_w", String.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                this.f59863a.addPostData("scr_h", String.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                this.f59863a.addPostData("q_type", String.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                this.f59863a.addPostData(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
                this.f59863a.addPostData("page_name", "PB");
                this.f59863a.addPostData("pic_index", String.valueOf(this.f59868f.f59854a.size()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public f doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
                this.f59863a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f59868f.f59862i);
                this.f59863a.addPostData("tid", this.f59864b);
                String str = this.f59865c;
                if (str != null) {
                    this.f59863a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
                }
                if (!TextUtils.isEmpty(this.f59868f.f59858e) && !"0".equals(this.f59868f.f59858e)) {
                    this.f59863a.addPostData("post_id", this.f59868f.f59858e);
                }
                this.f59863a.addPostData("source", String.valueOf(this.f59868f.q ? 1 : 2));
                this.f59868f.q = false;
                this.f59863a.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.f59866d));
                this.f59863a.addPostData("prev", String.valueOf(this.f59867e));
                this.f59863a.addPostData("not_see_lz", String.valueOf(!this.f59868f.p ? 1 : 0));
                this.f59863a.addPostData("is_top_agree", String.valueOf(this.f59868f.B ? 1 : 2));
                if (!this.f59868f.m) {
                    this.f59863a.addPostData(r.f7788a, String.valueOf(1));
                }
                if (!StringUtils.isNull(this.f59868f.u, true)) {
                    this.f59863a.addPostData("obj_type", this.f59868f.u);
                } else {
                    this.f59863a.addPostData("obj_type", "other");
                }
                if (TextUtils.isEmpty(this.f59868f.x)) {
                    if (System.currentTimeMillis() - d.a.p0.s.d0.b.j().l("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.f59868f.x = d.a.p0.s.d0.b.j().p("applist_intalled_apk_ids", "");
                    }
                }
                this.f59863a.addPostData("applist", this.f59868f.x);
                String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                if (!TextUtils.isEmpty(lastCachedOid)) {
                    this.f59863a.addPostData("oaid", lastCachedOid);
                }
                this.f59863a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.f59863a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.f59863a.postNetData();
                if (this.f59863a.getNetContext().getResponse().isRequestSuccess()) {
                    f fVar = new f();
                    fVar.l(postNetData, true);
                    return fVar;
                }
                return null;
            }
            return (f) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.f59863a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f59868f.n = null;
                super.cancel(true);
            }
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59865c : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r8v45, resolved type: com.baidu.tbadk.coreExtra.view.ImageUrlData */
        /* JADX DEBUG: Multi-variable search result rejected for r8v46, resolved type: com.baidu.tbadk.coreExtra.view.ImageUrlData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(f fVar) {
            ImageUrlData imageUrlData;
            boolean z;
            int i2;
            boolean z2;
            AgreeData agreeData;
            String str;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
                super.onPostExecute(fVar);
                if (this.f59868f.f59856c == null) {
                    return;
                }
                String str2 = null;
                this.f59868f.n = null;
                if (fVar == null) {
                    if (this.f59868f.r != null) {
                        NetWork netWork = this.f59863a;
                        if (netWork != null) {
                            i3 = netWork.getServerErrorCode();
                            if (this.f59865c == null) {
                                str2 = this.f59863a.getErrorString();
                            }
                        } else {
                            i3 = -1;
                        }
                        this.f59868f.r.b(i3, str2);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(fVar.g());
                if (this.f59868f.z && !isEmpty) {
                    this.f59868f.f59854a.clear();
                    this.f59868f.f59856c.clear();
                    this.f59868f.f59855b.clear();
                }
                if (fVar.h() != 0) {
                    this.f59868f.o = fVar.h();
                }
                this.f59868f.s = fVar.a();
                this.f59868f.Q = fVar.m;
                c cVar = this.f59868f;
                cVar.K = fVar.f59886i;
                cVar.L = fVar.i();
                c cVar2 = this.f59868f;
                cVar2.M = fVar.k;
                cVar2.N = fVar.j;
                cVar2.O = fVar.l == 1;
                if (this.f59865c == null) {
                    this.f59868f.f59854a.clear();
                    this.f59868f.f59855b.clear();
                }
                LinkedList<d> g2 = fVar.g();
                int size = g2.size();
                if (size <= 0) {
                    imageUrlData = null;
                    z = isEmpty;
                    this.f59868f.l = true;
                } else {
                    int i4 = 0;
                    while (i4 < size) {
                        d dVar = g2.get(i4);
                        String S = this.f59868f.S(dVar);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String f2 = dVar.f();
                        imageUrlData2.id = f2;
                        if (StringHelper.equals(f2, this.f59868f.A)) {
                            imageUrlData2.setSourceImageRectInScreen(this.f59868f.y);
                        }
                        imageUrlData2.imageUrl = S;
                        String str3 = S + "*" + dVar.k();
                        imageUrlData2.mWidth = dVar.r();
                        imageUrlData2.mHeigth = dVar.e();
                        imageUrlData2.urlType = 10;
                        imageUrlData2.originalUrl = dVar.i();
                        boolean z3 = isEmpty;
                        imageUrlData2.originalSize = dVar.j();
                        imageUrlData2.forumId = this.f59868f.f59861h;
                        imageUrlData2.forumName = this.f59868f.f59862i;
                        imageUrlData2.threadId = d.a.d.e.m.b.f(this.f59864b, -1L);
                        imageUrlData2.nid = this.f59868f.f59860g;
                        imageUrlData2.postId = d.a.d.e.m.b.f(dVar.c(), -1L);
                        imageUrlData2.userId = dVar.o();
                        imageUrlData2.userNameShow = StringUtils.isNull(dVar.q()) ? dVar.p() : dVar.q();
                        imageUrlData2.mIsReserver = this.f59868f.m;
                        imageUrlData2.mIsSeeHost = this.f59868f.p;
                        imageUrlData2.overAllIndex = dVar.k();
                        imageUrlData2.mThreadType = this.f59868f.v;
                        imageUrlData2.mPicType = dVar.l();
                        imageUrlData2.mTagName = dVar.n();
                        imageUrlData2.mIsShowOrigonButton = dVar.v();
                        imageUrlData2.isLongPic = dVar.u();
                        imageUrlData2.isBlockedPic = dVar.s();
                        imageUrlData2.from = this.f59868f.u;
                        if (dVar.m() != null) {
                            imageUrlData2.richTextArray = dVar.m().toString();
                        }
                        imageUrlData2.isFirstPost = dVar.t();
                        if (dVar.a() != null) {
                            AgreeData a2 = dVar.a();
                            imageUrlData2.agreeData = a2;
                            a2.isFromImageViewer = true;
                            a2.mImageViewerFromPage = this.f59868f.u;
                            imageUrlData2.agreeData.forumId = this.f59868f.f59861h;
                            imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                            AgreeData agreeData2 = imageUrlData2.agreeData;
                            agreeData2.nid = imageUrlData2.nid;
                            agreeData2.postId = String.valueOf(imageUrlData2.postId);
                            imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                            imageUrlData2.commentNum = dVar.d();
                            if (dVar.t()) {
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
                            imageUrlData2.agreeData.cardType = this.f59868f.F;
                            imageUrlData2.agreeData.recomSource = this.f59868f.G;
                            imageUrlData2.agreeData.recomAbTag = this.f59868f.H;
                            imageUrlData2.agreeData.recomExtra = this.f59868f.J;
                            imageUrlData2.agreeData.recomWeight = this.f59868f.I;
                        }
                        if (this.f59868f.f59855b.containsKey(imageUrlData2.id)) {
                            String str4 = (String) this.f59868f.f59855b.get(imageUrlData2.id);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.f59868f.f59856c.get(str4);
                            if (imageUrlData3 == null) {
                                this.f59868f.f59856c.put(str4, imageUrlData2);
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
                                imageUrlData3.forumId = this.f59868f.f59861h;
                                imageUrlData3.forumName = this.f59868f.f59862i;
                                imageUrlData3.mHeigth = imageUrlData2.mHeigth;
                                imageUrlData3.mWidth = imageUrlData2.mWidth;
                                if (StringHelper.equals(imageUrlData2.id, this.f59868f.A)) {
                                    imageUrlData3.setSourceImageRectInScreen(this.f59868f.y);
                                }
                            }
                            str = null;
                        } else if (!this.f59868f.C) {
                            str = null;
                            this.f59868f.f59856c.put(str3, imageUrlData2);
                            if (this.f59868f.w) {
                                this.f59868f.f59854a.add(i4, str3);
                            } else {
                                this.f59868f.f59854a.add(str3);
                            }
                            this.f59868f.f59855b.put(imageUrlData2.id, str3);
                        } else {
                            c cVar3 = this.f59868f;
                            cVar3.o = cVar3.f59856c.size();
                            str = null;
                            this.f59868f.s = null;
                        }
                        i4++;
                        isEmpty = z3;
                        str2 = str;
                    }
                    String str5 = str2;
                    z = isEmpty;
                    d dVar2 = (d) ListUtils.getItem(g2, 0);
                    if (dVar2 != null) {
                        this.f59868f.j = dVar2.f();
                    }
                    d dVar3 = (d) ListUtils.getItem(g2, size - 1);
                    imageUrlData = str5;
                    if (dVar3 != null) {
                        this.f59868f.k = dVar3.f();
                        c cVar4 = this.f59868f;
                        cVar4.l = ((long) cVar4.o) == dVar3.k();
                        imageUrlData = str5;
                    }
                }
                for (ImageUrlData imageUrlData4 : this.f59868f.f59856c.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData == null) {
                            for (ImageUrlData imageUrlData5 : this.f59868f.f59856c.values()) {
                                if (imageUrlData5.postId == j && (agreeData = imageUrlData5.agreeData) != null) {
                                    imageUrlData4.agreeData = agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = this.f59868f.f59861h;
                                    imageUrlData4.forumName = this.f59868f.f59862i;
                                    imageUrlData = imageUrlData5;
                                }
                            }
                        } else if (j == imageUrlData.postId) {
                            imageUrlData4.agreeData = imageUrlData.agreeData;
                            imageUrlData4.richTextArray = imageUrlData.richTextArray;
                            imageUrlData4.commentNum = imageUrlData.commentNum;
                            imageUrlData4.userId = imageUrlData.userId;
                            imageUrlData4.userNameShow = imageUrlData.userNameShow;
                            imageUrlData4.forumId = this.f59868f.f59861h;
                            imageUrlData4.forumName = this.f59868f.f59862i;
                        }
                    }
                }
                if (this.f59865c == null) {
                    this.f59868f.f59859f = this.f59864b;
                    i2 = 0;
                    z2 = true;
                } else {
                    i2 = -1;
                    z2 = false;
                }
                int position = this.f59868f.w ? ListUtils.getPosition(this.f59868f.f59854a, (String) this.f59868f.f59855b.get(this.f59865c)) - 1 : i2;
                this.f59868f.D = fVar.e();
                this.f59868f.E = fVar.j();
                this.f59868f.P = fVar.f();
                if (this.f59868f.f59857d == null) {
                    this.f59868f.f59857d = new ArrayList();
                    if (fVar.d() != null && fVar.g().size() > 0) {
                        this.f59868f.f59857d.addAll(fVar.d());
                    }
                }
                if (this.f59868f.r != null) {
                    this.f59868f.r.a(this.f59868f.f59854a, position, this.f59868f.o, false, null, z2, this.f59868f.s, z);
                }
                this.f59868f.z = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i2, int i3, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i2, String str);
    }

    public c(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, boolean z, int i3, String str8, String str9, String str10, String str11) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, map, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str8, str9, str10, str11};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59855b = new HashMap<>();
        this.l = false;
        this.m = true;
        this.n = null;
        this.o = 0;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = null;
        this.w = false;
        this.C = false;
        this.f59854a = arrayList;
        this.f59856c = map;
        if (arrayList == null) {
            this.f59854a = new ArrayList<>();
        }
        Iterator<String> it = this.f59854a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.f59855b.put(d.a.q0.k1.a.a(next), next);
        }
        this.f59859f = str3;
        this.f59860g = str4;
        this.f59862i = str2;
        this.f59861h = str;
        this.k = str5;
        this.v = i2;
        this.l = str5 == null;
        this.t = str6;
        this.u = str7;
        this.z = z;
        this.B = false;
        this.F = i3;
        this.G = str8;
        this.H = str9;
        this.I = str10;
        this.J = str11;
    }

    public final String S(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            if (dVar.b() != null && dVar.b().length() > 0) {
                return dVar.b();
            }
            StringBuilder sb = new StringBuilder(150);
            int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
            int i2 = threadImageMaxWidth * threadImageMaxWidth;
            if (dVar.e() * dVar.r() > i2) {
                double sqrt = Math.sqrt(i2 / (dVar.e() * dVar.r()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (dVar.r() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (dVar.e() * sqrt)));
            } else {
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf(dVar.r()));
                sb.append("&height=");
                sb.append(String.valueOf(dVar.e()));
            }
            sb.append("&src=");
            sb.append(k.getUrlEncode(dVar.g()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<AlaInfoData> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59857d : (ArrayList) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.w = false;
            if (this.l) {
                return;
            }
            i0(this.f59859f, this.k, 10, 0);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = true;
            String str = this.f59854a.get(0);
            if (StringUtils.isNull(this.j)) {
                this.j = d.a.q0.k1.a.a(str);
            }
            i0(this.f59859f, this.j, 0, 10);
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Q : invokeV.intValue;
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.A = str;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.q = z;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.C = z;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.B = z;
        }
    }

    public void d0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f59858e = str;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.m = z;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.p = z;
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.y = str;
        }
    }

    public final void i0(String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048592, this, str, str2, i2, i3) == null) {
            a aVar = this.n;
            if (aVar != null) {
                if (str2 != null && str2.equals(aVar.d())) {
                    return;
                }
                this.n.cancel();
            }
            a aVar2 = new a(this, str, str2, i2, i3);
            this.n = aVar2;
            aVar2.setPriority(3);
            this.n.execute(new Object[0]);
        }
    }
}
