package d.a.q0.h2.k.e.c1;

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
import d.a.d.a.f;
import d.a.d.e.p.l;
import d.a.d.e.p.q;
import d.a.p0.t.c.v;
import d.a.q0.h2.k.e.c1.b;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements QueryMatchEmotionModel.b, b.InterfaceC1423b, EmotionView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f57697e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f57698f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f57699g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h2.k.e.c1.b f57700h;

    /* renamed from: i  reason: collision with root package name */
    public QueryMatchEmotionModel f57701i;
    public String j;
    public Handler k;
    public ViewGroup l;
    public ViewGroup.LayoutParams m;
    public EditorTools n;
    public GetEmotionPidModel o;
    public Runnable p;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57702e;

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
            this.f57702e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57702e.j = "";
                this.f57702e.f57699g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AbsHListView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57703a;

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
            this.f57703a = cVar;
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
                    this.f57703a.k.removeCallbacks(this.f57703a.p);
                    this.f57703a.k.postDelayed(this.f57703a.p, 5000L);
                } else if (i2 != 1) {
                } else {
                    this.f57703a.k.removeCallbacks(this.f57703a.p);
                }
            }
        }
    }

    /* renamed from: d.a.q0.h2.k.e.c1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1424c implements GetEmotionPidModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f57704a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f57705b;

        public C1424c(c cVar, EmotionImageData emotionImageData) {
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
            this.f57705b = cVar;
            this.f57704a = emotionImageData;
        }

        @Override // com.baidu.tbadk.img.GetEmotionPidModel.b
        public void a(d.a.p0.c0.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || TextUtils.isEmpty(cVar.f52180a)) {
                return;
            }
            this.f57704a.setPicId(cVar.f52180a);
            this.f57705b.n(this.f57704a);
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
        this.f57697e = fVar;
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
                HListView hListView = this.f57699g;
                if (hListView == null || hListView.getParent() == null) {
                    HListView hListView2 = new HListView(this.f57697e.getContext());
                    this.f57699g = hListView2;
                    SkinManager.setBackgroundColor(hListView2, R.color.CAM_X0201);
                    this.f57699g.setDividerWidth(l.g(this.f57697e.getPageActivity(), R.dimen.ds7));
                    this.f57699g.setClipToPadding(false);
                    int g2 = l.g(this.f57697e.getPageActivity(), R.dimen.ds10);
                    this.f57699g.setPadding(g2, g2, g2, g2);
                    this.f57699g.setSelector(R.drawable.list_selector_transparent);
                    this.m.height = l.g(this.f57697e.getPageActivity(), R.dimen.ds136);
                    this.l.addView(this.f57699g, this.m);
                    if (this.f57700h == null) {
                        d.a.q0.h2.k.e.c1.b bVar = new d.a.q0.h2.k.e.c1.b();
                        this.f57700h = bVar;
                        bVar.d(this);
                        this.f57700h.c(this);
                        this.f57699g.setAdapter((ListAdapter) this.f57700h);
                        this.f57699g.setOnScrollListener(new b(this));
                    }
                }
                this.f57699g.setVisibility(0);
                this.f57700h.b(list);
                this.f57700h.notifyDataSetChanged();
                this.f57699g.setSelection(0);
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

    @Override // d.a.q0.h2.k.e.c1.b.InterfaceC1423b
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
            this.o.x(emotionImageData.getPicUrl(), new C1424c(this, emotionImageData));
        }
    }

    public void l() {
        QueryMatchEmotionModel queryMatchEmotionModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (queryMatchEmotionModel = this.f57701i) == null) {
            return;
        }
        queryMatchEmotionModel.cancelLoadData();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HListView hListView = this.f57699g;
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
            this.n.A(new d.a.p0.x.a(24, -1, vVar));
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str) || str.equals(this.j)) {
            return;
        }
        this.j = str;
        if (this.f57701i == null) {
            this.f57701i = new QueryMatchEmotionModel(this.f57697e);
        }
        this.f57701i.z(str, this);
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.b
    public void onFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.isEmpty(str) || ListUtils.isEmpty(this.f57698f) || !this.f57698f.contains(str)) {
            return;
        }
        o(str);
    }

    public void q(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f57698f = list;
        }
    }

    public void r(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editorTools) == null) {
            this.n = editorTools;
        }
    }
}
