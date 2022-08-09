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
import com.repackage.hu7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class i18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.y e;
    public hu7 f;

    /* loaded from: classes6.dex */
    public class a implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i18 a;

        public a(i18 i18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i18Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r9v14, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            j18 r1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.K().i2());
                    statisticItem.param("fid", this.a.a.K().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    if (this.a.b.x4()) {
                        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem2.param("fid", this.a.a.K().getForumId());
                        statisticItem2.param("tid", this.a.a.K().i2());
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("post_id", this.a.a.K().o1());
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 10);
                        statisticItem2.param("obj_locate", this.a.b.N3());
                        TiebaStatic.log(statisticItem2);
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (this.a.a.K().Q1().i0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i2 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().D() != null) {
                                ArrayList<TbRichTextImageInfo> D = tbRichTextView.getRichText().D();
                                int i3 = -1;
                                for (int i4 = 0; i4 < D.size(); i4++) {
                                    if (D.get(i4) != null) {
                                        arrayList.add(D.get(i4).F());
                                        if (i3 == -1 && str != null && str.equals(D.get(i4).F())) {
                                            i3 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = D.get(i4).F();
                                        imageUrlData.originalUrl = D.get(i4).F();
                                        imageUrlData.isLongPic = D.get(i4).I();
                                        concurrentHashMap.put(D.get(i4).F(), imageUrlData);
                                    }
                                }
                                i2 = i3;
                            }
                        }
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.y(arrayList);
                        builder.C(i2);
                        builder.D(false);
                        builder.G(this.a.a.K().b2());
                        builder.x(concurrentHashMap);
                        builder.I(true);
                        builder.L(false);
                        if (this.a.a.K() != null) {
                            builder.H(this.a.a.K().t1());
                            builder.B(this.a.a.K().getFromForumId());
                            if (this.a.a.K().Q1() != null) {
                                builder.O(this.a.a.K().Q1().O());
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
                        if (p != null && this.a.c >= 0 && this.a.c < p.B().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = gt7.a(p.B().get(this.a.c));
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
                            if (p.getPostId() != 0 && (r1 = this.a.a.r1()) != null) {
                                ArrayList<on> a2 = r1.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<on> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        on next = it.next();
                                        if ((next instanceof PostData) && p.getPostId() == og.g(((PostData) next).K(), 0L)) {
                                            i08.b(this.a.a.K().Q1(), (PostData) next, ((PostData) next).b0, 8, 3);
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
                            builder2.G(this.a.a.K().b2());
                            builder2.M(eVar.f);
                            if (this.a.a.K() != null) {
                                builder2.H(this.a.a.K().t1());
                                builder2.B(this.a.a.K().getFromForumId());
                                if (this.a.a.K().Q1() != null) {
                                    builder2.O(this.a.a.K().Q1().O());
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
                    builder3.G(this.a.a.K().b2());
                    builder3.L(false);
                    builder3.M(eVar.f);
                    builder3.E(false);
                    if (this.a.a.K() != null) {
                        builder3.H(this.a.a.K().t1());
                        builder3.B(this.a.a.K().getFromForumId());
                        if (this.a.a.K().Q1() != null) {
                            builder3.O(this.a.a.K().Q1().O());
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
    public class b implements hu7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i18 a;

        public b(i18 i18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i18Var;
        }

        @Override // com.repackage.hu7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091bd2) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.e5(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d2) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f091ffb) instanceof SparseArray) {
                                this.a.o((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091ffb));
                            }
                        } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f09182c) {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.o(sparseArray);
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.O5();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public i18(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
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
        this.f = new hu7(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.B();
    }

    public final void d(ft7 ft7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, ft7Var, arrayList) == null) || ft7Var == null || ft7Var.T() == null || ft7Var.T().a == null || (list = ft7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.K()) && !TextUtils.isEmpty(postData.K()) && next.K().equals(postData.K())) {
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
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText V = arrayList.get(i2).V();
                    if (V != null && (B = V.B()) != null) {
                        int size = B.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (B.get(i4) != null && B.get(i4).getType() == 8) {
                                i3++;
                                if (B.get(i4).F().B().equals(str) || B.get(i4).F().C().equals(str)) {
                                    int h = (int) qi.h(TbadkCoreApplication.getInst());
                                    int width = B.get(i4).F().getWidth() * h;
                                    int height = B.get(i4).F().getHeight() * h;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return V;
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
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i3 = i;
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i5);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i4++;
                        int h = (int) qi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h;
                        int height = tbRichTextData.F().getHeight() * h;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.F().H()) {
                            if (tbRichText == tbRichText2) {
                                if (i4 <= i2) {
                                    i3--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = gt7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                    String B = F.B();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        B = F.C();
                                    } else {
                                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.a.P()).get(VideoPbViewModel.class)).m() ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = B;
                                    imageUrlData.originalUrl = j(tbRichTextData);
                                    imageUrlData.originalSize = k(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
                                    imageUrlData.isLongPic = g(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = og.g(this.a.K().i2(), -1L);
                                    imageUrlData.mIsReserver = this.a.K().b2();
                                    imageUrlData.mIsSeeHost = this.a.K().t1();
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
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
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
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public final long k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public hu7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (hu7) invokeV.objValue;
    }

    public void m(String str, int i, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048585, this, str, i, eVar) == null) || eVar == null) {
            return;
        }
        ft7 Q1 = this.a.K().Q1();
        TbRichText p = p(str, i);
        if (p == null || (tbRichTextData = p.B().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(p.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a2 = gt7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.a.P()).get(VideoPbViewModel.class)).m() ? 17 : 18;
            }
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalUrl = j(tbRichTextData);
            imageUrlData.originalSize = k(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = h(tbRichTextData);
            imageUrlData.isLongPic = g(tbRichTextData);
            imageUrlData.postId = p.getPostId();
            imageUrlData.mIsReserver = this.a.K().b2();
            imageUrlData.mIsSeeHost = this.a.K().t1();
            eVar.b.put(a2, imageUrlData);
            if (Q1 != null) {
                if (Q1.l() != null) {
                    eVar.c = Q1.l().getName();
                    eVar.d = Q1.l().getId();
                }
                if (Q1.O() != null) {
                    eVar.e = Q1.O().getId();
                }
                eVar.g = Q1.s() == 1;
            }
            imageUrlData.threadId = og.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = Q1.F().size();
        this.d = false;
        eVar.j = -1;
        int f = Q1.j() != null ? f(Q1.j().V(), p, i, i, eVar.a, eVar.b) : i;
        for (int i2 = 0; i2 < size; i2++) {
            PostData postData = Q1.F().get(i2);
            if (postData.K() == null || Q1.j() == null || Q1.j().K() == null || !postData.K().equals(Q1.j().K())) {
                f = f(postData.V(), p, f, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (Q1 != null) {
            if (Q1.l() != null) {
                eVar.c = Q1.l().getName();
                eVar.d = Q1.l().getId();
            }
            if (Q1.O() != null) {
                eVar.e = Q1.O().getId();
            }
            eVar.g = Q1.s() == 1;
        }
        eVar.j = f;
    }

    public AbsPbActivity.e n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String str2 = null;
            if (this.a.K() != null && this.a.K().Q1() != null && this.a.K().Q1().F() != null && this.a.K().Q1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i >= this.a.K().Q1().F().size()) {
                        i = 0;
                        break;
                    } else if (str.equals(this.a.K().Q1().F().get(i).K())) {
                        break;
                    } else {
                        i++;
                    }
                }
                PostData postData = this.a.K().Q1().F().get(i);
                if (postData.V() != null && postData.V().B() != null) {
                    Iterator<TbRichTextData> it = postData.V().B().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.F() != null) {
                                str2 = next.F().B();
                            }
                        }
                    }
                    m(str2, 0, eVar);
                    gt7.b(postData, eVar);
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
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.obfuscated_res_0x7f091fe8) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)) == null || this.a.K() == null || this.a.K().Q1() == null || postData.B() == 1) {
            return;
        }
        String i2 = this.a.K().i2();
        String K = postData.K();
        int W = this.a.K().Q1() != null ? this.a.K().Q1().W() : 0;
        AbsPbActivity.e n = n(K);
        if (n == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(i2, K, "pb", true, this.b.x4(), null, false, null, W, postData.b0(), this.a.K().Q1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 0).addBigImageData(n.a, n.b, n.g, n.j);
        addBigImageData.setKeyPageStartFrom(this.a.K().P1());
        addBigImageData.setFromFrsForumId(this.a.K().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.K().n2());
        addBigImageData.setKeyFromForumId(this.a.K().getForumId());
        addBigImageData.setBjhData(this.a.K().i1());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText p(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.K() == null || this.a.K().Q1() == null || str == null || i < 0) {
                return null;
            }
            ft7 Q1 = this.a.K().Q1();
            if (Q1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(Q1.j());
                tbRichText = e(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = Q1.F();
                d(Q1, F);
                return e(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
