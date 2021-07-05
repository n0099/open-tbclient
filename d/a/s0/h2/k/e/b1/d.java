package d.a.s0.h2.k.e.b1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f60365e;

    /* renamed from: f  reason: collision with root package name */
    public List<EmotionImageData> f60366f;

    /* renamed from: g  reason: collision with root package name */
    public Set<String> f60367g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.h2.k.e.b1.a f60368h;

    /* renamed from: i  reason: collision with root package name */
    public int f60369i;
    public int j;
    public List<String> k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60370e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60370e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (tag = view.getTag(view.getId())) != null && (tag instanceof EmotionImageData)) {
                if (this.f60370e.f60368h != null && (view instanceof EmotionView)) {
                    this.f60370e.f60368h.a((EmotionImageData) tag, ((EmotionView) view).getIsGif());
                }
                TiebaStatic.log("c12180");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f60371a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60371a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.f60371a.f60367g != null) {
                    for (String str : this.f60371a.f60367g) {
                        if (!TextUtils.isEmpty(str)) {
                            d.a.r0.a0.c.k().h(str);
                        }
                    }
                    return Boolean.TRUE;
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f60372a;

        /* renamed from: b  reason: collision with root package name */
        public EmotionView f60373b;

        /* renamed from: c  reason: collision with root package name */
        public EmotionView f60374c;

        /* renamed from: d  reason: collision with root package name */
        public EmotionView f60375d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f60376e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60376e = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60376e.e(this.f60372a);
                this.f60376e.e(this.f60373b);
                this.f60376e.e(this.f60374c);
                this.f60376e.e(this.f60375d);
            }
        }
    }

    public d(List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60365e = BdBaseApplication.getInst().getApp();
        this.f60366f = list;
        this.f60367g = new HashSet();
        this.j = l.g(this.f60365e, R.dimen.ds116);
        this.f60369i = (int) (((l.k(this.f60365e) - l.g(this.f60365e, R.dimen.ds88)) - (this.j * 4)) * 0.333d);
    }

    public final void d(EmotionView emotionView, EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, emotionView, emotionImageData) == null) || emotionView == null || emotionImageData == null) {
            return;
        }
        emotionView.setTag(emotionView.getId(), emotionImageData);
        emotionView.q0();
        emotionView.t0(emotionImageData);
        if (this.f60367g == null || TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
            return;
        }
        if (ListUtils.isEmpty(this.k) || !this.k.contains(emotionImageData.getThumbUrl())) {
            Set<String> set = this.f60367g;
            set.add(emotionImageData.getThumbUrl() + emotionView.getLoadProcType());
        }
    }

    public final void e(EmotionView emotionView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionView) == null) || emotionView == null) {
            return;
        }
        emotionView.setOnClickListener(new a(this));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new b(this).execute(new Void[0]);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f60368h = null;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f60366f.size() % 4 == 0) {
                return this.f60366f.size() / 4;
            }
            return (this.f60366f.size() / 4) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f60366f.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c cVar2 = new c(this);
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_search_emotion_item, (ViewGroup) null);
                cVar2.f60372a = (EmotionView) inflate.findViewById(R.id.emotion_view1);
                cVar2.f60373b = (EmotionView) inflate.findViewById(R.id.emotion_view2);
                cVar2.f60374c = (EmotionView) inflate.findViewById(R.id.emotion_view3);
                cVar2.f60375d = (EmotionView) inflate.findViewById(R.id.emotion_view4);
                cVar2.a();
                i(cVar2.f60373b, this.f60369i);
                i(cVar2.f60374c, this.f60369i);
                i(cVar2.f60375d, this.f60369i);
                inflate.setTag(cVar2);
                cVar = cVar2;
                view = inflate;
            } else {
                cVar = (c) view.getTag();
            }
            int i3 = i2 * 4;
            int i4 = i3 + 4;
            int min = Math.min(i4, this.f60366f.size() - 1);
            for (int i5 = i3; i5 < i4; i5++) {
                if (i5 <= min) {
                    EmotionImageData emotionImageData = this.f60366f.get(i5);
                    int i6 = i5 - i3;
                    if (i6 == 0) {
                        d(cVar.f60372a, emotionImageData);
                    } else if (i6 == 1) {
                        d(cVar.f60373b, emotionImageData);
                    } else if (i6 == 2) {
                        d(cVar.f60374c, emotionImageData);
                    } else if (i6 == 3) {
                        d(cVar.f60375d, emotionImageData);
                    }
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.k = list;
        }
    }

    public final void i(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, view, i2) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i2;
        view.setLayoutParams(marginLayoutParams);
    }

    public void j(d.a.s0.h2.k.e.b1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f60368h = aVar;
        }
    }
}
