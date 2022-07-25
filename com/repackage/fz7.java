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
import com.repackage.ls7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class fz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.y e;
    public ls7 f;

    /* loaded from: classes6.dex */
    public class a implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz7 a;

        public a(fz7 fz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz7Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v14, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            gz7 s1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.F().j2());
                    statisticItem.param("fid", this.a.a.F().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    if (this.a.b.y4()) {
                        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem2.param("fid", this.a.a.F().getForumId());
                        statisticItem2.param("tid", this.a.a.F().j2());
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("post_id", this.a.a.F().p1());
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 10);
                        statisticItem2.param("obj_locate", this.a.b.O3());
                        TiebaStatic.log(statisticItem2);
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (this.a.a.F().R1().g0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i2 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().E() != null) {
                                ArrayList<TbRichTextImageInfo> E = tbRichTextView.getRichText().E();
                                int i3 = -1;
                                for (int i4 = 0; i4 < E.size(); i4++) {
                                    if (E.get(i4) != null) {
                                        arrayList.add(E.get(i4).G());
                                        if (i3 == -1 && str != null && str.equals(E.get(i4).G())) {
                                            i3 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = E.get(i4).G();
                                        imageUrlData.originalUrl = E.get(i4).G();
                                        imageUrlData.isLongPic = E.get(i4).J();
                                        concurrentHashMap.put(E.get(i4).G(), imageUrlData);
                                    }
                                }
                                i2 = i3;
                            }
                        }
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.y(arrayList);
                        builder.C(i2);
                        builder.D(false);
                        builder.G(this.a.a.F().c2());
                        builder.x(concurrentHashMap);
                        builder.I(true);
                        builder.L(false);
                        if (this.a.a.F() != null) {
                            builder.H(this.a.a.F().u1());
                            builder.B(this.a.a.F().getFromForumId());
                            if (this.a.a.F().R1() != null) {
                                builder.O(this.a.a.F().R1().O());
                            }
                        }
                        ImageViewerConfig w = builder.w(this.a.a.getPageContext().getPageActivity());
                        w.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, w));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.m(str, i, eVar);
                    if (eVar.h) {
                        TbRichText p = this.a.p(str, i);
                        if (p != null && this.a.c >= 0 && this.a.c < p.C().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = kr7.a(p.C().get(this.a.c));
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
                            if (p.getPostId() != 0 && (s1 = this.a.a.s1()) != null) {
                                ArrayList<nn> a2 = s1.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<nn> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        nn next = it.next();
                                        if ((next instanceof PostData) && p.getPostId() == ng.g(((PostData) next).J(), 0L)) {
                                            fy7.b(this.a.a.F().R1(), (PostData) next, ((PostData) next).b0, 8, 3);
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
                            ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                            builder2.y(arrayList2);
                            builder2.A(eVar.c);
                            builder2.z(eVar.d);
                            builder2.P(eVar.e);
                            builder2.D(eVar.g);
                            builder2.I(true);
                            builder2.K(eVar.i);
                            builder2.x(concurrentHashMap2);
                            builder2.L(false);
                            builder2.G(this.a.a.F().c2());
                            builder2.M(eVar.f);
                            if (this.a.a.F() != null) {
                                builder2.H(this.a.a.F().u1());
                                builder2.B(this.a.a.F().getFromForumId());
                                if (this.a.a.F().R1() != null) {
                                    builder2.O(this.a.a.F().R1().O());
                                }
                            }
                            ImageViewerConfig w2 = builder2.w(this.a.a.getPageContext().getPageActivity());
                            w2.getIntent().putExtra("from", "pb");
                            this.a.a.sendMessage(new CustomMessage(2010000, w2));
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
                    ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                    builder3.y(arrayList3);
                    builder3.A(eVar.c);
                    builder3.z(eVar.d);
                    builder3.P(eVar.e);
                    builder3.D(eVar.g);
                    builder3.I(true);
                    builder3.K(eVar.a.get(0));
                    builder3.x(concurrentHashMap3);
                    builder3.G(this.a.a.F().c2());
                    builder3.L(false);
                    builder3.M(eVar.f);
                    builder3.E(false);
                    if (this.a.a.F() != null) {
                        builder3.H(this.a.a.F().u1());
                        builder3.B(this.a.a.F().getFromForumId());
                        if (this.a.a.F().R1() != null) {
                            builder3.O(this.a.a.F().R1().O());
                        }
                    }
                    ImageViewerConfig w3 = builder3.w(this.a.a.getPageContext().getPageActivity());
                    w3.getIntent().putExtra("from", "pb");
                    this.a.a.sendMessage(new CustomMessage(2010000, w3));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ls7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz7 a;

        public b(fz7 fz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz7Var;
        }

        @Override // com.repackage.ls7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091af1) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.f5(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091706) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f091f04) instanceof SparseArray) {
                                this.a.o((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091f04));
                            }
                        } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f09175f) {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.o(sparseArray);
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.P5();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public fz7(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
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
        this.f = new ls7(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.B();
    }

    public final void d(jr7 jr7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jr7Var, arrayList) == null) || jr7Var == null || jr7Var.T() == null || jr7Var.T().a == null || (list = jr7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.J()) && !TextUtils.isEmpty(postData.J()) && next.J().equals(postData.J())) {
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
        ArrayList<TbRichTextData> C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText Q = arrayList.get(i2).Q();
                    if (Q != null && (C = Q.C()) != null) {
                        int size = C.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (C.get(i4) != null && C.get(i4).getType() == 8) {
                                i3++;
                                if (C.get(i4).G().C().equals(str) || C.get(i4).G().D().equals(str)) {
                                    int h = (int) pi.h(TbadkCoreApplication.getInst());
                                    int width = C.get(i4).G().getWidth() * h;
                                    int height = C.get(i4).G().getHeight() * h;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return Q;
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
        TbRichTextImageInfo G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.C().size();
                int i3 = i;
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    TbRichTextData tbRichTextData = tbRichText.C().get(i5);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i4++;
                        int h = (int) pi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.G().getWidth() * h;
                        int height = tbRichTextData.G().getHeight() * h;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.G().I()) {
                            if (tbRichText == tbRichText2) {
                                if (i4 <= i2) {
                                    i3--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = kr7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (G = tbRichTextData.G()) != null) {
                                    String C = G.C();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        C = G.D();
                                    } else {
                                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.a.N()).get(VideoPbViewModel.class)).m() ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = C;
                                    imageUrlData.originalUrl = j(tbRichTextData);
                                    imageUrlData.originalSize = k(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
                                    imageUrlData.isLongPic = g(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = ng.g(this.a.F().j2(), -1L);
                                    imageUrlData.mIsReserver = this.a.F().c2();
                                    imageUrlData.mIsSeeHost = this.a.F().u1();
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
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return false;
            }
            return tbRichTextData.G().J();
        }
        return invokeL.booleanValue;
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return false;
            }
            return tbRichTextData.G().K();
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
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return null;
            }
            return tbRichTextData.G().E();
        }
        return (String) invokeL.objValue;
    }

    public final long k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.G() == null) {
                return 0L;
            }
            return tbRichTextData.G().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public ls7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (ls7) invokeV.objValue;
    }

    public void m(String str, int i, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048585, this, str, i, eVar) == null) || eVar == null) {
            return;
        }
        jr7 R1 = this.a.F().R1();
        TbRichText p = p(str, i);
        if (p == null || (tbRichTextData = p.C().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(p.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.G().I()) {
            eVar.h = false;
            String a2 = kr7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.a.N()).get(VideoPbViewModel.class)).m() ? 17 : 18;
            }
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalSize = k(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
            imageUrlData.isLongPic = g(tbRichTextData);
            imageUrlData.postId = p.getPostId();
            imageUrlData.mIsReserver = this.a.F().c2();
            imageUrlData.mIsSeeHost = this.a.F().u1();
            eVar.b.put(a2, imageUrlData);
            if (R1 != null) {
                if (R1.l() != null) {
                    eVar.c = R1.l().getName();
                    eVar.d = R1.l().getId();
                }
                if (R1.O() != null) {
                    eVar.e = R1.O().getId();
                }
                eVar.g = R1.s() == 1;
            }
            imageUrlData.threadId = ng.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = R1.F().size();
        this.d = false;
        eVar.j = -1;
        int f = R1.j() != null ? f(R1.j().Q(), p, i, i, eVar.a, eVar.b) : i;
        for (int i2 = 0; i2 < size; i2++) {
            PostData postData = R1.F().get(i2);
            if (postData.J() == null || R1.j() == null || R1.j().J() == null || !postData.J().equals(R1.j().J())) {
                f = f(postData.Q(), p, f, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (R1 != null) {
            if (R1.l() != null) {
                eVar.c = R1.l().getName();
                eVar.d = R1.l().getId();
            }
            if (R1.O() != null) {
                eVar.e = R1.O().getId();
            }
            eVar.g = R1.s() == 1;
        }
        eVar.j = f;
    }

    public AbsPbActivity.e n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String str2 = null;
            if (this.a.F() != null && this.a.F().R1() != null && this.a.F().R1().F() != null && this.a.F().R1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i >= this.a.F().R1().F().size()) {
                        i = 0;
                        break;
                    } else if (str.equals(this.a.F().R1().F().get(i).J())) {
                        break;
                    } else {
                        i++;
                    }
                }
                PostData postData = this.a.F().R1().F().get(i);
                if (postData.Q() != null && postData.Q().C() != null) {
                    Iterator<TbRichTextData> it = postData.Q().C().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.G() != null) {
                                str2 = next.G().C();
                            }
                        }
                    }
                    m(str2, 0, eVar);
                    kr7.b(postData, eVar);
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
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.obfuscated_res_0x7f091ef1) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091ef1)) == null || this.a.F() == null || this.a.F().R1() == null || postData.B() == 1) {
            return;
        }
        String j2 = this.a.F().j2();
        String J = postData.J();
        int V = this.a.F().R1() != null ? this.a.F().R1().V() : 0;
        AbsPbActivity.e n = n(J);
        if (n == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(j2, J, "pb", true, this.b.y4(), null, false, null, V, postData.V(), this.a.F().R1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 0).addBigImageData(n.a, n.b, n.g, n.j);
        addBigImageData.setKeyPageStartFrom(this.a.F().Q1());
        addBigImageData.setFromFrsForumId(this.a.F().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.F().o2());
        addBigImageData.setKeyFromForumId(this.a.F().getForumId());
        addBigImageData.setBjhData(this.a.F().j1());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText p(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.F() == null || this.a.F().R1() == null || str == null || i < 0) {
                return null;
            }
            jr7 R1 = this.a.F().R1();
            if (R1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(R1.j());
                tbRichText = e(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = R1.F();
                d(R1, F);
                return e(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
