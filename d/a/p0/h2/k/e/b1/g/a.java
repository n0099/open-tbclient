package d.a.p0.h2.k.e.b1.g;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f57150e;

    /* renamed from: f  reason: collision with root package name */
    public int f57151f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f57152g;

    /* renamed from: h  reason: collision with root package name */
    public PbEmotionBar.i f57153h;

    /* renamed from: i  reason: collision with root package name */
    public Set<String> f57154i;

    /* renamed from: d.a.p0.h2.k.e.b1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1415a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57155e;

        public View$OnClickListenerC1415a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57155e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f57155e.f57153h != null && (view instanceof EmotionView)) {
                EmotionView emotionView = (EmotionView) view;
                this.f57155e.f57153h.b(emotionView.getData(), emotionView.getIsGif());
                TiebaStatic.log("c12176");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57156e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57156e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57156e.f57153h == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.f57156e.f57150e)) {
                for (EmotionImageData emotionImageData : this.f57156e.f57150e) {
                    if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        arrayList.add(emotionImageData.getThumbUrl());
                    }
                }
            }
            this.f57156e.f57153h.a(null, null, arrayList);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f57157a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57157a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.f57157a.f57154i != null) {
                    for (String str : this.f57157a.f57154i) {
                        if (!TextUtils.isEmpty(str)) {
                            d.a.o0.a0.c.k().h(str);
                        }
                    }
                    return Boolean.TRUE;
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f57158a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57159b;

        public d() {
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

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57154i = new HashSet();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new c(this).execute(new Void[0]);
        }
    }

    public void e(List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f57150e = list;
        }
    }

    public void f(EmotionView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f57152g = cVar;
        }
    }

    public void g(PbEmotionBar.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f57153h = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f57150e)) {
                return 0;
            }
            return this.f57150e.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
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
        View view2;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d();
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
                EmotionView emotionView = (EmotionView) view2.findViewById(R.id.iv_emotion);
                dVar.f57158a = emotionView;
                emotionView.q0();
                dVar.f57158a.setController(this.f57152g);
                dVar.f57158a.setOnClickListener(new View$OnClickListenerC1415a(this));
                TextView textView = (TextView) view2.findViewById(R.id.tv_more);
                dVar.f57159b = textView;
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                dVar.f57159b.setOnClickListener(new b(this));
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            if (i2 >= 0) {
                if (i2 < this.f57150e.size()) {
                    dVar.f57158a.getLayoutParams().width = this.f57151f;
                    dVar.f57158a.getLayoutParams().height = this.f57151f;
                    dVar.f57158a.I();
                    dVar.f57158a.setTag(R.id.iv_emotion, null);
                    EmotionImageData emotionImageData = this.f57150e.get(i2);
                    if (emotionImageData != null) {
                        dVar.f57158a.t0(emotionImageData);
                        if (this.f57154i != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                            Set<String> set = this.f57154i;
                            set.add(emotionImageData.getThumbUrl() + dVar.f57158a.getLoadProcType());
                        }
                    }
                    dVar.f57158a.setVisibility(0);
                    dVar.f57159b.setVisibility(8);
                } else if (i2 == this.f57150e.size()) {
                    dVar.f57159b.getLayoutParams().width = this.f57151f;
                    dVar.f57159b.getLayoutParams().height = this.f57151f;
                    dVar.f57158a.setVisibility(8);
                    dVar.f57159b.setVisibility(0);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f57151f == i2) {
            return;
        }
        this.f57151f = i2;
        notifyDataSetChanged();
    }
}
