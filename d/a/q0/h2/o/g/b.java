package d.a.q0.h2.o.g;

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
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.q0.h2.h.e;
import d.a.q0.h2.h.f;
import d.a.q0.h2.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseVideoPBReplyFragment f58411a;

    /* renamed from: b  reason: collision with root package name */
    public AbsVideoPbFragment f58412b;

    /* renamed from: c  reason: collision with root package name */
    public int f58413c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58414d;

    /* renamed from: e  reason: collision with root package name */
    public final TbRichTextView.z f58415e;

    /* renamed from: f  reason: collision with root package name */
    public c f58416f;

    /* loaded from: classes8.dex */
    public class a implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58417a;

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
            this.f58417a = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v14, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            d.a.q0.h2.o.h.a M0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.f58417a.f58411a.y().b1());
                    statisticItem.param("fid", this.f58417a.f58411a.y().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    if (this.f58417a.f58412b.N3()) {
                        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem2.param("fid", this.f58417a.f58411a.y().getForumId());
                        statisticItem2.param("tid", this.f58417a.f58411a.y().b1());
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("post_id", this.f58417a.f58411a.y().m0());
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 10);
                        statisticItem2.param("obj_locate", this.f58417a.f58412b.d3());
                        TiebaStatic.log(statisticItem2);
                    }
                    TiebaStatic.eventStat(this.f58417a.f58411a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (this.f58417a.f58411a.y().L0().e0()) {
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
                        bVar.F(this.f58417a.f58411a.y().W0());
                        bVar.w(concurrentHashMap);
                        bVar.H(true);
                        bVar.K(false);
                        if (this.f58417a.f58411a.y() != null) {
                            bVar.G(this.f58417a.f58411a.y().q0());
                            bVar.A(this.f58417a.f58411a.y().getFromForumId());
                            if (this.f58417a.f58411a.y().L0() != null) {
                                bVar.N(this.f58417a.f58411a.y().L0().N());
                            }
                        }
                        ImageViewerConfig v = bVar.v(this.f58417a.f58411a.getPageContext().getPageActivity());
                        v.getIntent().putExtra("from", "pb");
                        this.f58417a.f58411a.sendMessage(new CustomMessage(2010000, v));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.f58417a.m(str, i2, eVar);
                    if (eVar.f19268h) {
                        TbRichText p = this.f58417a.p(str, i2);
                        if (p != null && this.f58417a.f58413c >= 0 && this.f58417a.f58413c < p.y().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a2 = f.a(p.y().get(this.f58417a.f58413c));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.f19261a.size()) {
                                    break;
                                } else if (eVar.f19261a.get(i6).equals(a2)) {
                                    eVar.j = i6;
                                    arrayList2.add(a2);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            if (p.getPostId() != 0 && (M0 = this.f58417a.f58411a.M0()) != null) {
                                ArrayList<n> a3 = M0.a();
                                if (ListUtils.getCount(a3) > 0) {
                                    Iterator<n> it = a3.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        n next = it.next();
                                        if ((next instanceof PostData) && p.getPostId() == d.a.d.e.m.b.f(((PostData) next).E(), 0L)) {
                                            d.a.q0.h2.m.a.b(this.f58417a.f58411a.y().L0(), (PostData) next, ((PostData) next).i0, 8, 3);
                                            break;
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.f19262b.get(str2));
                            }
                            ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                            bVar2.x(arrayList2);
                            bVar2.z(eVar.f19263c);
                            bVar2.y(eVar.f19264d);
                            bVar2.O(eVar.f19265e);
                            bVar2.C(eVar.f19267g);
                            bVar2.H(true);
                            bVar2.J(eVar.f19269i);
                            bVar2.w(concurrentHashMap2);
                            bVar2.K(false);
                            bVar2.F(this.f58417a.f58411a.y().W0());
                            bVar2.L(eVar.f19266f);
                            if (this.f58417a.f58411a.y() != null) {
                                bVar2.G(this.f58417a.f58411a.y().q0());
                                bVar2.A(this.f58417a.f58411a.y().getFromForumId());
                                if (this.f58417a.f58411a.y().L0() != null) {
                                    bVar2.N(this.f58417a.f58411a.y().L0().N());
                                }
                            }
                            ImageViewerConfig v2 = bVar2.v(this.f58417a.f58411a.getPageContext().getPageActivity());
                            v2.getIntent().putExtra("from", "pb");
                            this.f58417a.f58411a.sendMessage(new CustomMessage(2010000, v2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(ListUtils.getItem(eVar.f19261a, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!ListUtils.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, eVar.f19262b.get(str3));
                    }
                    ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                    bVar3.x(arrayList3);
                    bVar3.z(eVar.f19263c);
                    bVar3.y(eVar.f19264d);
                    bVar3.O(eVar.f19265e);
                    bVar3.C(eVar.f19267g);
                    bVar3.H(true);
                    bVar3.J(eVar.f19261a.get(0));
                    bVar3.w(concurrentHashMap3);
                    bVar3.F(this.f58417a.f58411a.y().W0());
                    bVar3.K(false);
                    bVar3.L(eVar.f19266f);
                    bVar3.D(false);
                    if (this.f58417a.f58411a.y() != null) {
                        bVar3.G(this.f58417a.f58411a.y().q0());
                        bVar3.A(this.f58417a.f58411a.y().getFromForumId());
                        if (this.f58417a.f58411a.y().L0() != null) {
                            bVar3.N(this.f58417a.f58411a.y().L0().N());
                        }
                    }
                    ImageViewerConfig v3 = bVar3.v(this.f58417a.f58411a.getPageContext().getPageActivity());
                    v3.getIntent().putExtra("from", "pb");
                    this.f58417a.f58411a.sendMessage(new CustomMessage(2010000, v3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* renamed from: d.a.q0.h2.o.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1447b implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58418a;

        public C1447b(b bVar) {
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
            this.f58418a = bVar;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.f58418a.f58412b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view != null) {
                        if (view.getId() == R.id.richText) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.f58418a.f58412b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.r4(view)) {
                                return true;
                            }
                        } else if (view.getId() == R.id.pb_floor_item_layout) {
                            if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.f58418a.o((SparseArray) view.getTag(R.id.tag_from));
                            }
                        } else if ((view instanceof TbRichTextView) || view.getId() == R.id.pb_post_header_layout) {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.f58418a.o(sparseArray);
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.f58418a.f58412b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.a5();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
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
        this.f58413c = 0;
        this.f58414d = false;
        this.f58415e = new a(this);
        this.f58416f = new c(new C1447b(this));
        this.f58411a = baseVideoPBReplyFragment;
        this.f58412b = baseVideoPBReplyFragment.v();
    }

    public final void d(e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, arrayList) == null) || eVar == null || eVar.S() == null || eVar.S().f57500a == null || (list = eVar.S().f57500a) == null || arrayList == null) {
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
                                    this.f58413c = i5;
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
                this.f58414d = true;
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
                                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.f58411a.z()).get(VideoPbViewModel.class)).l() ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = y;
                                    imageUrlData.originalUrl = j(tbRichTextData);
                                    imageUrlData.originalSize = k(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
                                    imageUrlData.isLongPic = g(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = d.a.d.e.m.b.f(this.f58411a.y().b1(), -1L);
                                    imageUrlData.mIsReserver = this.f58411a.y().W0();
                                    imageUrlData.mIsSeeHost = this.f58411a.y().q0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a2, imageUrlData);
                                    }
                                }
                            }
                            if (!this.f58414d) {
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

    public TbRichTextView.z i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58415e : (TbRichTextView.z) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58416f : (c) invokeV.objValue;
    }

    public void m(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048585, this, str, i2, eVar) == null) || eVar == null) {
            return;
        }
        e L0 = this.f58411a.y().L0();
        TbRichText p = p(str, i2);
        if (p == null || (tbRichTextData = p.y().get(this.f58413c)) == null) {
            return;
        }
        eVar.f19266f = String.valueOf(p.getPostId());
        eVar.f19261a = new ArrayList<>();
        eVar.f19262b = new ConcurrentHashMap<>();
        if (!tbRichTextData.B().D()) {
            eVar.f19268h = false;
            String a2 = f.a(tbRichTextData);
            eVar.f19261a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.f58411a.z()).get(VideoPbViewModel.class)).l() ? 17 : 18;
            }
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalSize = k(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
            imageUrlData.isLongPic = g(tbRichTextData);
            imageUrlData.postId = p.getPostId();
            imageUrlData.mIsReserver = this.f58411a.y().W0();
            imageUrlData.mIsSeeHost = this.f58411a.y().q0();
            eVar.f19262b.put(a2, imageUrlData);
            if (L0 != null) {
                if (L0.m() != null) {
                    eVar.f19263c = L0.m().getName();
                    eVar.f19264d = L0.m().getId();
                }
                if (L0.N() != null) {
                    eVar.f19265e = L0.N().d0();
                }
                eVar.f19267g = L0.t() == 1;
            }
            imageUrlData.threadId = d.a.d.e.m.b.f(eVar.f19265e, -1L);
            return;
        }
        eVar.f19268h = true;
        int size = L0.E().size();
        this.f58414d = false;
        eVar.j = -1;
        int f2 = L0.j() != null ? f(L0.j().K(), p, i2, i2, eVar.f19261a, eVar.f19262b) : i2;
        for (int i3 = 0; i3 < size; i3++) {
            PostData postData = L0.E().get(i3);
            if (postData.E() == null || L0.j() == null || L0.j().E() == null || !postData.E().equals(L0.j().E())) {
                f2 = f(postData.K(), p, f2, i2, eVar.f19261a, eVar.f19262b);
            }
        }
        if (eVar.f19261a.size() > 0) {
            ArrayList<String> arrayList = eVar.f19261a;
            eVar.f19269i = arrayList.get(arrayList.size() - 1);
        }
        if (L0 != null) {
            if (L0.m() != null) {
                eVar.f19263c = L0.m().getName();
                eVar.f19264d = L0.m().getId();
            }
            if (L0.N() != null) {
                eVar.f19265e = L0.N().d0();
            }
            eVar.f19267g = L0.t() == 1;
        }
        eVar.j = f2;
    }

    public AbsPbActivity.e n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String str2 = null;
            if (this.f58411a.y() != null && this.f58411a.y().L0() != null && this.f58411a.y().L0().E() != null && this.f58411a.y().L0().E().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f58411a.y().L0().E().size()) {
                        i2 = 0;
                        break;
                    } else if (str.equals(this.f58411a.y().L0().E().get(i2).E())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                PostData postData = this.f58411a.y().L0().E().get(i2);
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
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void o(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || !this.f58411a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null || this.f58411a.y() == null || this.f58411a.y().L0() == null || postData.A() == 1) {
            return;
        }
        String b1 = this.f58411a.y().b1();
        String E = postData.E();
        int U = this.f58411a.y().L0() != null ? this.f58411a.y().L0().U() : 0;
        AbsPbActivity.e n = n(E);
        if (n == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f58411a.getPageContext().getPageActivity()).createSubPbActivityConfig(b1, E, "pb", true, this.f58412b.N3(), null, false, null, U, postData.O(), this.f58411a.y().L0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 0).addBigImageData(n.f19261a, n.f19262b, n.f19267g, n.j);
        addBigImageData.setKeyPageStartFrom(this.f58411a.y().K0());
        addBigImageData.setFromFrsForumId(this.f58411a.y().getFromForumId());
        addBigImageData.setWorksInfoData(this.f58411a.y().f1());
        addBigImageData.setKeyFromForumId(this.f58411a.y().getForumId());
        addBigImageData.setBjhData(this.f58411a.y().g0());
        this.f58411a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText p(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) {
            TbRichText tbRichText = null;
            if (this.f58411a.y() == null || this.f58411a.y().L0() == null || str == null || i2 < 0) {
                return null;
            }
            e L0 = this.f58411a.y().L0();
            if (L0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(L0.j());
                tbRichText = e(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> E = L0.E();
                d(L0, E);
                return e(E, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
