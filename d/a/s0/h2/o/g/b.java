package d.a.s0.h2.o.g;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.s0.h2.h.e;
import d.a.s0.h2.h.f;
import d.a.s0.h2.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseVideoPBReplyFragment f61080a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPbFragment f61081b;

    /* renamed from: c  reason: collision with root package name */
    public int f61082c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61083d;

    /* renamed from: e  reason: collision with root package name */
    public final TbRichTextView.x f61084e;

    /* renamed from: f  reason: collision with root package name */
    public c f61085f;

    /* loaded from: classes9.dex */
    public class a implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61086a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61086a = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v13, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            d.a.s0.h2.o.h.a G0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.f61086a.f61080a.y().T0());
                    statisticItem.param("fid", this.f61086a.f61080a.y().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.f61086a.f61080a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (this.f61086a.f61080a.y().D0().e0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        if (view.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().A() != null) {
                                ArrayList<TbRichTextImageInfo> A = tbRichTextView.getRichText().A();
                                int i4 = -1;
                                for (int i5 = 0; i5 < A.size(); i5++) {
                                    if (A.get(i5) != null) {
                                        arrayList.add(A.get(i5).B());
                                        if (i4 == -1 && str != null && str.equals(A.get(i5).B())) {
                                            i4 = i5;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = A.get(i5).B();
                                        imageUrlData.originalUrl = A.get(i5).B();
                                        imageUrlData.isLongPic = A.get(i5).E();
                                        concurrentHashMap.put(A.get(i5).B(), imageUrlData);
                                    }
                                }
                                i3 = i4;
                            }
                        }
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList);
                        bVar.B(i3);
                        bVar.C(false);
                        bVar.F(this.f61086a.f61080a.y().O0());
                        bVar.w(concurrentHashMap);
                        bVar.H(true);
                        bVar.K(false);
                        if (this.f61086a.f61080a.y() != null) {
                            bVar.G(this.f61086a.f61080a.y().i0());
                            bVar.A(this.f61086a.f61080a.y().getFromForumId());
                            if (this.f61086a.f61080a.y().D0() != null) {
                                bVar.N(this.f61086a.f61080a.y().D0().N());
                            }
                        }
                        ImageViewerConfig v = bVar.v(this.f61086a.f61080a.getPageContext().getPageActivity());
                        v.getIntent().putExtra("from", "pb");
                        this.f61086a.f61080a.sendMessage(new CustomMessage(2010000, v));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    PbActivity.e eVar = new PbActivity.e();
                    this.f61086a.m(str, i2, eVar);
                    if (eVar.f19143h) {
                        TbRichText p = this.f61086a.p(str, i2);
                        if (p != null && this.f61086a.f61082c >= 0 && this.f61086a.f61082c < p.y().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a2 = f.a(p.y().get(this.f61086a.f61082c));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.f19136a.size()) {
                                    break;
                                } else if (eVar.f19136a.get(i6).equals(a2)) {
                                    eVar.j = i6;
                                    arrayList2.add(a2);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            if (p.getPostId() != 0 && (G0 = this.f61086a.f61080a.G0()) != null) {
                                ArrayList<n> a3 = G0.a();
                                if (ListUtils.getCount(a3) > 0) {
                                    Iterator<n> it = a3.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        n next = it.next();
                                        if ((next instanceof PostData) && p.getPostId() == d.a.c.e.m.b.f(((PostData) next).E(), 0L)) {
                                            d.a.s0.h2.m.a.b(this.f61086a.f61080a.y().D0(), (PostData) next, ((PostData) next).i0, 8, 3);
                                            break;
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.f19137b.get(str2));
                            }
                            ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                            bVar2.x(arrayList2);
                            bVar2.z(eVar.f19138c);
                            bVar2.y(eVar.f19139d);
                            bVar2.O(eVar.f19140e);
                            bVar2.C(eVar.f19142g);
                            bVar2.H(true);
                            bVar2.J(eVar.f19144i);
                            bVar2.w(concurrentHashMap2);
                            bVar2.K(false);
                            bVar2.F(this.f61086a.f61080a.y().O0());
                            bVar2.L(eVar.f19141f);
                            if (this.f61086a.f61080a.y() != null) {
                                bVar2.G(this.f61086a.f61080a.y().i0());
                                bVar2.A(this.f61086a.f61080a.y().getFromForumId());
                                if (this.f61086a.f61080a.y().D0() != null) {
                                    bVar2.N(this.f61086a.f61080a.y().D0().N());
                                }
                            }
                            ImageViewerConfig v2 = bVar2.v(this.f61086a.f61080a.getPageContext().getPageActivity());
                            v2.getIntent().putExtra("from", "pb");
                            this.f61086a.f61080a.sendMessage(new CustomMessage(2010000, v2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(ListUtils.getItem(eVar.f19136a, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!ListUtils.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, eVar.f19137b.get(str3));
                    }
                    ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                    bVar3.x(arrayList3);
                    bVar3.z(eVar.f19138c);
                    bVar3.y(eVar.f19139d);
                    bVar3.O(eVar.f19140e);
                    bVar3.C(eVar.f19142g);
                    bVar3.H(true);
                    bVar3.J(eVar.f19136a.get(0));
                    bVar3.w(concurrentHashMap3);
                    bVar3.F(this.f61086a.f61080a.y().O0());
                    bVar3.K(false);
                    bVar3.L(eVar.f19141f);
                    bVar3.D(false);
                    if (this.f61086a.f61080a.y() != null) {
                        bVar3.G(this.f61086a.f61080a.y().i0());
                        bVar3.A(this.f61086a.f61080a.y().getFromForumId());
                        if (this.f61086a.f61080a.y().D0() != null) {
                            bVar3.N(this.f61086a.f61080a.y().D0().N());
                        }
                    }
                    ImageViewerConfig v3 = bVar3.v(this.f61086a.f61080a.getPageContext().getPageActivity());
                    v3.getIntent().putExtra("from", "pb");
                    this.f61086a.f61080a.sendMessage(new CustomMessage(2010000, v3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* renamed from: d.a.s0.h2.o.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1485b implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61087a;

        public C1485b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61087a = bVar;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                VideoPbFragment videoPbFragment = this.f61087a.f61081b;
                if (videoPbFragment != null && videoPbFragment.isAdded()) {
                    if (view != null) {
                        if (view.getId() == R.id.richText) {
                            VideoPbFragment videoPbFragment2 = this.f61087a.f61081b;
                            if (videoPbFragment2 != null && videoPbFragment2.m4(view)) {
                                return true;
                            }
                        } else if (view.getId() == R.id.pb_floor_item_layout) {
                            if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.f61087a.o((SparseArray) view.getTag(R.id.tag_from));
                            }
                        } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.f61087a.o(sparseArray);
                        }
                    }
                    VideoPbFragment videoPbFragment3 = this.f61087a.f61081b;
                    if (videoPbFragment3 != null) {
                        videoPbFragment3.U4();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public b(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseVideoPBReplyFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61082c = 0;
        this.f61083d = false;
        this.f61084e = new a(this);
        this.f61085f = new c(new C1485b(this));
        this.f61080a = baseVideoPBReplyFragment;
        this.f61081b = baseVideoPBReplyFragment.v();
    }

    public final void d(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, arrayList) == null) || eVar == null || eVar.S() == null || eVar.S().f60195a == null || (list = eVar.S().f60195a) == null || arrayList == null) {
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
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText K = arrayList.get(i3).K();
                    if (K != null && (y = K.y()) != null) {
                        int size = y.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (y.get(i5) != null && y.get(i5).getType() == 8) {
                                i4++;
                                if (y.get(i5).B().y().equals(str) || y.get(i5).B().z().equals(str)) {
                                    int h2 = (int) l.h(TbadkCoreApplication.getInst());
                                    int width = y.get(i5).B().getWidth() * h2;
                                    int height = y.get(i5).B().getHeight() * h2;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.f61082c = i5;
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
        return (TbRichText) invokeLLI.objValue;
    }

    public final int f(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.f61083d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.y().size();
                int i4 = i2;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.y().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int h2 = (int) l.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.B().getWidth() * h2;
                        int height = tbRichTextData.B().getHeight() * h2;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.B().D()) {
                            if (tbRichText == tbRichText2) {
                                if (i5 <= i3) {
                                    i4--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = f.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (B = tbRichTextData.B()) != null) {
                                    String y = B.y();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        y = B.z();
                                    } else {
                                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.f61080a.z()).get(VideoPbViewModel.class)).l() ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = y;
                                    imageUrlData.originalUrl = j(tbRichTextData);
                                    imageUrlData.originalSize = k(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
                                    imageUrlData.isLongPic = g(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = d.a.c.e.m.b.f(this.f61080a.y().T0(), -1L);
                                    imageUrlData.mIsReserver = this.f61080a.y().O0();
                                    imageUrlData.mIsSeeHost = this.f61080a.y().i0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a2, imageUrlData);
                                    }
                                }
                            }
                            if (!this.f61083d) {
                                i4++;
                            }
                        }
                    }
                }
                return i4;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final boolean g(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return false;
            }
            return tbRichTextData.B().E();
        }
        return invokeL.booleanValue;
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return false;
            }
            return tbRichTextData.B().F();
        }
        return invokeL.booleanValue;
    }

    public TbRichTextView.x i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61084e : (TbRichTextView.x) invokeV.objValue;
    }

    public final String j(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return null;
            }
            return tbRichTextData.B().A();
        }
        return (String) invokeL.objValue;
    }

    public final long k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return 0L;
            }
            return tbRichTextData.B().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public c l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f61085f : (c) invokeV.objValue;
    }

    public void m(String str, int i2, PbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048585, this, str, i2, eVar) == null) || eVar == null) {
            return;
        }
        e D0 = this.f61080a.y().D0();
        TbRichText p = p(str, i2);
        if (p == null || (tbRichTextData = p.y().get(this.f61082c)) == null) {
            return;
        }
        eVar.f19141f = String.valueOf(p.getPostId());
        eVar.f19136a = new ArrayList<>();
        eVar.f19137b = new ConcurrentHashMap<>();
        if (!tbRichTextData.B().D()) {
            eVar.f19143h = false;
            String a2 = f.a(tbRichTextData);
            eVar.f19136a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.f61080a.z()).get(VideoPbViewModel.class)).l() ? 17 : 18;
            }
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalSize = k(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
            imageUrlData.isLongPic = g(tbRichTextData);
            imageUrlData.postId = p.getPostId();
            imageUrlData.mIsReserver = this.f61080a.y().O0();
            imageUrlData.mIsSeeHost = this.f61080a.y().i0();
            eVar.f19137b.put(a2, imageUrlData);
            if (D0 != null) {
                if (D0.m() != null) {
                    eVar.f19138c = D0.m().getName();
                    eVar.f19139d = D0.m().getId();
                }
                if (D0.N() != null) {
                    eVar.f19140e = D0.N().c0();
                }
                eVar.f19142g = D0.t() == 1;
            }
            imageUrlData.threadId = d.a.c.e.m.b.f(eVar.f19140e, -1L);
            return;
        }
        eVar.f19143h = true;
        int size = D0.E().size();
        this.f61083d = false;
        eVar.j = -1;
        int f2 = D0.j() != null ? f(D0.j().K(), p, i2, i2, eVar.f19136a, eVar.f19137b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = D0.E().get(i3);
            if (postData.E() == null || D0.j() == null || D0.j().E() == null || !postData.E().equals(D0.j().E())) {
                f2 = f(postData.K(), p, f2, i2, eVar.f19136a, eVar.f19137b);
            }
        }
        if (eVar.f19136a.size() > 0) {
            ArrayList<String> arrayList = eVar.f19136a;
            eVar.f19144i = arrayList.get(arrayList.size() - 1);
        }
        if (D0 != null) {
            if (D0.m() != null) {
                eVar.f19138c = D0.m().getName();
                eVar.f19139d = D0.m().getId();
            }
            if (D0.N() != null) {
                eVar.f19140e = D0.N().c0();
            }
            eVar.f19142g = D0.t() == 1;
        }
        eVar.j = f2;
    }

    public PbActivity.e n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String str2 = null;
            if (this.f61080a.y() != null && this.f61080a.y().D0() != null && this.f61080a.y().D0().E() != null && this.f61080a.y().D0().E().size() != 0 && !StringUtils.isNull(str)) {
                PbActivity.e eVar = new PbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f61080a.y().D0().E().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.f61080a.y().D0().E().get(i2).E())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.f61080a.y().D0().E().get(i2);
                if (postData.K() != null && postData.K().y() != null) {
                    Iterator<TbRichTextData> it = postData.K().y().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.B() != null) {
                                str2 = next.B().y();
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
        return (PbActivity.e) invokeL.objValue;
    }

    public final void o(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || !this.f61080a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null || this.f61080a.y() == null || this.f61080a.y().D0() == null || postData.A() == 1) {
            return;
        }
        String T0 = this.f61080a.y().T0();
        String E = postData.E();
        int U = this.f61080a.y().D0() != null ? this.f61080a.y().D0().U() : 0;
        PbActivity.e n = n(E);
        if (n == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f61080a.getPageContext().getPageActivity()).createSubPbActivityConfig(T0, E, "pb", true, null, false, null, U, postData.O(), this.f61080a.y().D0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null).addBigImageData(n.f19136a, n.f19137b, n.f19142g, n.j);
        addBigImageData.setKeyPageStartFrom(this.f61080a.y().C0());
        addBigImageData.setFromFrsForumId(this.f61080a.y().getFromForumId());
        addBigImageData.setKeyFromForumId(this.f61080a.y().getForumId());
        addBigImageData.setBjhData(this.f61080a.y().Y());
        this.f61080a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText p(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) {
            TbRichText tbRichText = null;
            if (this.f61080a.y() == null || this.f61080a.y().D0() == null || str == null || i2 < 0) {
                return null;
            }
            e D0 = this.f61080a.y().D0();
            if (D0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(D0.j());
                tbRichText = e(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> E = D0.E();
                d(D0, E);
                return e(E, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
