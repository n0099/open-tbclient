package d.a.s0.h2.k.e.b1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f60351e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1457b f60352f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f60353g;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60354e;

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
            this.f60354e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f60354e.f60352f != null && (view instanceof EmotionView)) {
                this.f60354e.f60352f.f(((EmotionView) view).getData());
            }
        }
    }

    /* renamed from: d.a.s0.h2.k.e.b1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1457b {
        void f(EmotionImageData emotionImageData);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f60355a;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void b(List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f60351e = list;
        }
    }

    public void c(EmotionView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f60353g = cVar;
        }
    }

    public void d(InterfaceC1457b interfaceC1457b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC1457b) == null) {
            this.f60352f = interfaceC1457b;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.f60351e)) {
                return 0;
            }
            return this.f60351e.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                cVar = new c();
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
                EmotionView emotionView = (EmotionView) view2.findViewById(R.id.emotion_view);
                cVar.f60355a = emotionView;
                emotionView.q0();
                cVar.f60355a.setController(this.f60353g);
                cVar.f60355a.setOnClickListener(new a(this));
                view2.setTag(cVar);
            } else {
                view2 = view;
                cVar = (c) view.getTag();
            }
            List<EmotionImageData> list = this.f60351e;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                cVar.f60355a.t0(this.f60351e.get(i2));
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
