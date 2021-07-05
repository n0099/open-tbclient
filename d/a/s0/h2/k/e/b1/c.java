package d.a.s0.h2.k.e.b1;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.c.e.p.q;
import d.a.r0.s.c.v;
import d.a.s0.h2.k.e.b1.b;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1457b, EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f60356e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f60357f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f60358g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.h2.k.e.b1.b f60359h;

    /* renamed from: i  reason: collision with root package name */
    public QueryMatchEmotionModel f60360i;
    public String j;
    public Handler k;
    public ViewGroup l;
    public ViewGroup.LayoutParams m;
    public EditorTools n;
    public GetEmotionPidModel o;
    public Runnable p;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60361e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60361e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60361e.j = "";
                this.f60361e.f60358g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AbsHListView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f60362a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60362a = cVar;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absHListView, i2, i3, i4) == null) {
            }
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absHListView, i2) == null) {
                if (i2 == 0) {
                    this.f60362a.k.removeCallbacks(this.f60362a.p);
                    this.f60362a.k.postDelayed(this.f60362a.p, 5000L);
                } else if (i2 != 1) {
                } else {
                    this.f60362a.k.removeCallbacks(this.f60362a.p);
                }
            }
        }
    }

    /* renamed from: d.a.s0.h2.k.e.b1.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1458c implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f60363a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f60364b;

        public C1458c(c cVar, EmotionImageData emotionImageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, emotionImageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60364b = cVar;
            this.f60363a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.a.r0.b0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f54827a)) {
                return;
            }
            this.f60363a.setPicId(cVar.f54827a);
            this.f60364b.n(this.f60363a);
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    public c(f fVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, viewGroup, layoutParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.f60356e = fVar;
        this.l = viewGroup;
        this.m = layoutParams;
        this.k = new Handler();
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void a(String str, List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) && !TextUtils.isEmpty(str) && str.equals(this.j)) {
            if (ListUtils.isEmpty(list)) {
                this.j = "";
            } else if (this.l == null || this.m == null) {
            } else {
                if (list.size() > 10) {
                    list = list.subList(0, 10);
                }
                TiebaStatic.log("c12488");
                HListView hListView = this.f60358g;
                if (hListView == null || hListView.getParent() == null) {
                    HListView hListView2 = new HListView(this.f60356e.getContext());
                    this.f60358g = hListView2;
                    SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                    this.f60358g.setDividerWidth(l.g(this.f60356e.getPageActivity(), R.dimen.ds7));
                    this.f60358g.setClipToPadding(false);
                    int g2 = l.g(this.f60356e.getPageActivity(), R.dimen.ds10);
                    this.f60358g.setPadding(g2, g2, g2, g2);
                    this.f60358g.setSelector(R.drawable.list_selector_transparent);
                    this.m.height = l.g(this.f60356e.getPageActivity(), R.dimen.ds136);
                    this.l.addView(this.f60358g, this.m);
                    if (this.f60359h == null) {
                        d.a.s0.h2.k.e.b1.b bVar = new d.a.s0.h2.k.e.b1.b();
                        this.f60359h = bVar;
                        bVar.d(this);
                        this.f60359h.c(this);
                        this.f60358g.setAdapter((ListAdapter) this.f60359h);
                        this.f60358g.setOnScrollListener(new b(this));
                    }
                }
                this.f60358g.setVisibility(0);
                this.f60359h.b(list);
                this.f60359h.notifyDataSetChanged();
                this.f60358g.setSelection(0);
                this.k.removeCallbacks(this.p);
                this.k.postDelayed(this.p, 5000L);
            }
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.removeCallbacks(this.p);
            this.k.postDelayed(this.p, 5000L);
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.removeCallbacks(this.p);
        }
    }

    @Override // com.baidu.tieba.face.view.EmotionView.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.h2.k.e.b1.b.InterfaceC1457b
    public void f(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, emotionImageData) == null) {
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
            this.o.x(emotionImageData.getPicUrl(), new C1458c(this, emotionImageData));
        }
    }

    public void l() {
        QueryMatchEmotionModel queryMatchEmotionModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (queryMatchEmotionModel = this.f60360i) == null) {
            return;
        }
        queryMatchEmotionModel.cancelLoadData();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HListView hListView = this.f60358g;
            if (hListView != null) {
                hListView.setVisibility(8);
            }
            this.k.removeCallbacks(this.p);
            this.j = "";
        }
    }

    public final void n(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, emotionImageData) == null) {
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
            this.n.A(new d.a.r0.w.a(24, -1, vVar));
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str) || str.equals(this.j)) {
            return;
        }
        this.j = str;
        if (this.f60360i == null) {
            this.f60360i = new QueryMatchEmotionModel(this.f60356e);
        }
        this.f60360i.z(str, this);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f60357f) || !this.f60357f.contains(str)) {
            return;
        }
        o(str);
    }

    public void q(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f60357f = list;
        }
    }

    public void r(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editorTools) == null) {
            this.n = editorTools;
        }
    }
}
