package com.repackage;

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
import com.repackage.dt7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class vz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.y e;
    public dt7 f;

    /* loaded from: classes7.dex */
    public class a implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public a(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v14, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            wz7 C0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.v().h2());
                    statisticItem.param("fid", this.a.a.v().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    if (this.a.b.F3()) {
                        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem2.param("fid", this.a.a.v().getForumId());
                        statisticItem2.param("tid", this.a.a.v().h2());
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("post_id", this.a.a.v().n1());
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 10);
                        statisticItem2.param("obj_locate", this.a.b.V2());
                        TiebaStatic.log(statisticItem2);
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (this.a.a.v().P1().g0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i2 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().C() != null) {
                                ArrayList<TbRichTextImageInfo> C = tbRichTextView.getRichText().C();
                                int i3 = -1;
                                for (int i4 = 0; i4 < C.size(); i4++) {
                                    if (C.get(i4) != null) {
                                        arrayList.add(C.get(i4).D());
                                        if (i3 == -1 && str != null && str.equals(C.get(i4).D())) {
                                            i3 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = C.get(i4).D();
                                        imageUrlData.originalUrl = C.get(i4).D();
                                        imageUrlData.isLongPic = C.get(i4).G();
                                        concurrentHashMap.put(C.get(i4).D(), imageUrlData);
                                    }
                                }
                                i2 = i3;
                            }
                        }
                        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                        bVar.x(arrayList);
                        bVar.B(i2);
                        bVar.C(false);
                        bVar.F(this.a.a.v().a2());
                        bVar.w(concurrentHashMap);
                        bVar.H(true);
                        bVar.K(false);
                        if (this.a.a.v() != null) {
                            bVar.G(this.a.a.v().s1());
                            bVar.A(this.a.a.v().getFromForumId());
                            if (this.a.a.v().P1() != null) {
                                bVar.N(this.a.a.v().P1().O());
                            }
                        }
                        ImageViewerConfig v = bVar.v(this.a.a.getPageContext().getPageActivity());
                        v.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, v));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.m(str, i, eVar);
                    if (eVar.h) {
                        TbRichText p = this.a.p(str, i);
                        if (p != null && this.a.c >= 0 && this.a.c < p.A().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = cs7.a(p.A().get(this.a.c));
                            int i5 = 0;
                            while (true) {
                                if (i5 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i5).equals(a)) {
                                    eVar.j = i5;
                                    arrayList2.add(a);
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                            if (p.getPostId() != 0 && (C0 = this.a.a.C0()) != null) {
                                ArrayList<ro> a2 = C0.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<ro> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        ro next = it.next();
                                        if ((next instanceof PostData) && p.getPostId() == kg.g(((PostData) next).I(), 0L)) {
                                            vy7.b(this.a.a.v().P1(), (PostData) next, ((PostData) next).h0, 8, 3);
                                            break;
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.b.get(str2));
                            }
                            ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                            bVar2.x(arrayList2);
                            bVar2.z(eVar.c);
                            bVar2.y(eVar.d);
                            bVar2.O(eVar.e);
                            bVar2.C(eVar.g);
                            bVar2.H(true);
                            bVar2.J(eVar.i);
                            bVar2.w(concurrentHashMap2);
                            bVar2.K(false);
                            bVar2.F(this.a.a.v().a2());
                            bVar2.L(eVar.f);
                            if (this.a.a.v() != null) {
                                bVar2.G(this.a.a.v().s1());
                                bVar2.A(this.a.a.v().getFromForumId());
                                if (this.a.a.v().P1() != null) {
                                    bVar2.N(this.a.a.v().P1().O());
                                }
                            }
                            ImageViewerConfig v2 = bVar2.v(this.a.a.getPageContext().getPageActivity());
                            v2.getIntent().putExtra("from", "pb");
                            this.a.a.sendMessage(new CustomMessage(2010000, v2));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(ListUtils.getItem(eVar.a, 0));
                    ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                    if (!ListUtils.isEmpty(arrayList3)) {
                        String str3 = (String) arrayList3.get(0);
                        concurrentHashMap3.put(str3, eVar.b.get(str3));
                    }
                    ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                    bVar3.x(arrayList3);
                    bVar3.z(eVar.c);
                    bVar3.y(eVar.d);
                    bVar3.O(eVar.e);
                    bVar3.C(eVar.g);
                    bVar3.H(true);
                    bVar3.J(eVar.a.get(0));
                    bVar3.w(concurrentHashMap3);
                    bVar3.F(this.a.a.v().a2());
                    bVar3.K(false);
                    bVar3.L(eVar.f);
                    bVar3.D(false);
                    if (this.a.a.v() != null) {
                        bVar3.G(this.a.a.v().s1());
                        bVar3.A(this.a.a.v().getFromForumId());
                        if (this.a.a.v().P1() != null) {
                            bVar3.N(this.a.a.v().P1().O());
                        }
                    }
                    ImageViewerConfig v3 = bVar3.v(this.a.a.getPageContext().getPageActivity());
                    v3.getIntent().putExtra("from", "pb");
                    this.a.a.sendMessage(new CustomMessage(2010000, v3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements dt7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public b(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091ac8) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.m4(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0916da) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f091ec1) instanceof SparseArray) {
                                this.a.o((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091ec1));
                            }
                        } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f091732) {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.o(sparseArray);
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.W4();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public vz7(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseVideoPBReplyFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = false;
        this.e = new a(this);
        this.f = new dt7(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.s();
    }

    public final void d(bs7 bs7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bs7Var, arrayList) == null) || bs7Var == null || bs7Var.T() == null || bs7Var.T().a == null || (list = bs7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.I()) && !TextUtils.isEmpty(postData.I()) && next.I().equals(postData.I())) {
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

    public final TbRichText e(ArrayList<PostData> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText P = arrayList.get(i2).P();
                    if (P != null && (A = P.A()) != null) {
                        int size = A.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (A.get(i4) != null && A.get(i4).getType() == 8) {
                                i3++;
                                if (A.get(i4).E().A().equals(str) || A.get(i4).E().B().equals(str)) {
                                    int h = (int) mi.h(TbadkCoreApplication.getInst());
                                    int width = A.get(i4).E().getWidth() * h;
                                    int height = A.get(i4).E().getHeight() * h;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return P;
                                } else if (i3 > i) {
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

    public final int f(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.A().size();
                int i3 = i;
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    TbRichTextData tbRichTextData = tbRichText.A().get(i5);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i4++;
                        int h = (int) mi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.E().getWidth() * h;
                        int height = tbRichTextData.E().getHeight() * h;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.E().F()) {
                            if (tbRichText == tbRichText2) {
                                if (i4 <= i2) {
                                    i3--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = cs7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (E = tbRichTextData.E()) != null) {
                                    String A = E.A();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        A = E.B();
                                    } else {
                                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.a.w()).get(VideoPbViewModel.class)).m() ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = A;
                                    imageUrlData.originalUrl = j(tbRichTextData);
                                    imageUrlData.originalSize = k(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
                                    imageUrlData.isLongPic = g(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = kg.g(this.a.v().h2(), -1L);
                                    imageUrlData.mIsReserver = this.a.v().a2();
                                    imageUrlData.mIsSeeHost = this.a.v().s1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a2, imageUrlData);
                                    }
                                }
                            }
                            if (!this.d) {
                                i3++;
                            }
                        }
                    }
                }
                return i3;
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public final boolean g(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().G();
        }
        return invokeL.booleanValue;
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().H();
        }
        return invokeL.booleanValue;
    }

    public TbRichTextView.y i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (TbRichTextView.y) invokeV.objValue;
    }

    public final String j(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return null;
            }
            return tbRichTextData.E().C();
        }
        return (String) invokeL.objValue;
    }

    public final long k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return 0L;
            }
            return tbRichTextData.E().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public dt7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (dt7) invokeV.objValue;
    }

    public void m(String str, int i, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048585, this, str, i, eVar) == null) || eVar == null) {
            return;
        }
        bs7 P1 = this.a.v().P1();
        TbRichText p = p(str, i);
        if (p == null || (tbRichTextData = p.A().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(p.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.E().F()) {
            eVar.h = false;
            String a2 = cs7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.a.w()).get(VideoPbViewModel.class)).m() ? 17 : 18;
            }
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalSize = k(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
            imageUrlData.isLongPic = g(tbRichTextData);
            imageUrlData.postId = p.getPostId();
            imageUrlData.mIsReserver = this.a.v().a2();
            imageUrlData.mIsSeeHost = this.a.v().s1();
            eVar.b.put(a2, imageUrlData);
            if (P1 != null) {
                if (P1.l() != null) {
                    eVar.c = P1.l().getName();
                    eVar.d = P1.l().getId();
                }
                if (P1.O() != null) {
                    eVar.e = P1.O().getId();
                }
                eVar.g = P1.s() == 1;
            }
            imageUrlData.threadId = kg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = P1.F().size();
        this.d = false;
        eVar.j = -1;
        int f = P1.j() != null ? f(P1.j().P(), p, i, i, eVar.a, eVar.b) : i;
        for (int i2 = 0; i2 < size; i2++) {
            PostData postData = P1.F().get(i2);
            if (postData.I() == null || P1.j() == null || P1.j().I() == null || !postData.I().equals(P1.j().I())) {
                f = f(postData.P(), p, f, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (P1 != null) {
            if (P1.l() != null) {
                eVar.c = P1.l().getName();
                eVar.d = P1.l().getId();
            }
            if (P1.O() != null) {
                eVar.e = P1.O().getId();
            }
            eVar.g = P1.s() == 1;
        }
        eVar.j = f;
    }

    public AbsPbActivity.e n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String str2 = null;
            if (this.a.v() != null && this.a.v().P1() != null && this.a.v().P1().F() != null && this.a.v().P1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i >= this.a.v().P1().F().size()) {
                        i = 0;
                        break;
                    } else if (str.equals(this.a.v().P1().F().get(i).I())) {
                        break;
                    } else {
                        i++;
                    }
                }
                PostData postData = this.a.v().P1().F().get(i);
                if (postData.P() != null && postData.P().A() != null) {
                    Iterator<TbRichTextData> it = postData.P().A().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.E() != null) {
                                str2 = next.E().A();
                            }
                        }
                    }
                    m(str2, 0, eVar);
                    cs7.b(postData, eVar);
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
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.obfuscated_res_0x7f091eae) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae)) == null || this.a.v() == null || this.a.v().P1() == null || postData.A() == 1) {
            return;
        }
        String h2 = this.a.v().h2();
        String I = postData.I();
        int V = this.a.v().P1() != null ? this.a.v().P1().V() : 0;
        AbsPbActivity.e n = n(I);
        if (n == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(h2, I, "pb", true, this.b.F3(), null, false, null, V, postData.U(), this.a.v().P1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 0).addBigImageData(n.a, n.b, n.g, n.j);
        addBigImageData.setKeyPageStartFrom(this.a.v().O1());
        addBigImageData.setFromFrsForumId(this.a.v().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.v().m2());
        addBigImageData.setKeyFromForumId(this.a.v().getForumId());
        addBigImageData.setBjhData(this.a.v().h1());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText p(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.v() == null || this.a.v().P1() == null || str == null || i < 0) {
                return null;
            }
            bs7 P1 = this.a.v().P1();
            if (P1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(P1.j());
                tbRichText = e(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = P1.F();
                d(P1, F);
                return e(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
