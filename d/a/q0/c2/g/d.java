package d.a.q0.c2.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f55246e;

    /* renamed from: f  reason: collision with root package name */
    public Context f55247f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.c0.b f55248g;

    /* renamed from: h  reason: collision with root package name */
    public int f55249h;

    /* renamed from: i  reason: collision with root package name */
    public int f55250i;
    public c j;

    /* loaded from: classes8.dex */
    public class a extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55251a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1314d f55252b;

        public a(d dVar, ViewGroup viewGroup, C1314d c1314d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup, c1314d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55251a = viewGroup;
            this.f55252b = c1314d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null || (findViewWithTag = this.f55251a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f55252b.f55254a);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55253e;

        public b(d dVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55253e = viewGroup;
        }

        @Override // d.a.p0.b0.b
        public void a(d.a.d.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f55253e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            aVar.h(tbImageView);
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onAdd();

        void onDel(FaceData faceData);
    }

    /* renamed from: d.a.q0.c2.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1314d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f55254a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f55255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f55256c;

        /* renamed from: d.a.q0.c2.g.d$d$a */
        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1314d f55257e;

            public a(C1314d c1314d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1314d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55257e = c1314d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f55257e.f55256c.j != null && view.getTag(view.getId()) != null && (view.getTag(view.getId()) instanceof FaceData) && ((FaceData) view.getTag(view.getId())).type == 4) {
                    this.f55257e.f55256c.j.onAdd();
                }
            }
        }

        /* renamed from: d.a.q0.c2.g.d$d$b */
        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1314d f55258e;

            public b(C1314d c1314d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1314d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55258e = c1314d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55258e.f55256c.j == null || view.getTag() == null || !(view.getTag() instanceof FaceData)) {
                    return;
                }
                this.f55258e.f55256c.j.onDel((FaceData) view.getTag());
            }
        }

        public C1314d(d dVar) {
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
            this.f55256c = dVar;
        }

        public final void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55254a = (TbImageView) view.findViewById(R.id.image);
                this.f55255b = (ImageView) view.findViewById(R.id.delete_icon);
                ViewGroup.LayoutParams layoutParams = this.f55254a.getLayoutParams();
                layoutParams.width = this.f55256c.f55249h;
                layoutParams.height = this.f55256c.f55249h;
                SkinManager.setImageResource(this.f55255b, R.drawable.icon_live_close_n);
                this.f55254a.setOnClickListener(new a(this));
                this.f55255b.setOnClickListener(new b(this));
            }
        }
    }

    public d(List<FaceData> list) {
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
        this.f55247f = BdBaseApplication.getInst().getApp();
        this.f55246e = list;
        this.f55248g = new d.a.p0.c0.b();
        int k = l.k(this.f55247f);
        this.f55250i = k;
        this.f55249h = (k - (l.g(this.f55247f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1314d c1314d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, viewGroup, c1314d) == null) || imageFileInfo == null) {
            return;
        }
        imageFileInfo.clearPageActions();
        int i2 = this.f55249h;
        imageFileInfo.addPageAction(d.a.p0.c0.g.d.g(i2, i2));
        d.a.d.k.d.a c2 = this.f55248g.c(imageFileInfo, false);
        c1314d.f55254a.setTag(imageFileInfo.toCachedKey(false));
        if (c2 != null) {
            c2.h(c1314d.f55254a);
            c1314d.f55254a.setTag(null);
        } else {
            this.f55248g.e(imageFileInfo, new b(this, viewGroup), false, false);
        }
        c1314d.f55255b.setVisibility(0);
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1314d c1314d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, viewGroup, c1314d) == null) || emotionImageData == null) {
            return;
        }
        Object k = d.a.d.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1314d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
        d.a.d.k.d.a aVar = (k == null || !(k instanceof d.a.d.k.d.a)) ? null : (d.a.d.k.d.a) k;
        if (aVar != null) {
            aVar.h(c1314d.f55254a);
            c1314d.f55254a.setTag(null);
        }
        c1314d.f55255b.setVisibility(0);
    }

    public final void e(EmotionImageData emotionImageData, C1314d c1314d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionImageData, c1314d) == null) || emotionImageData == null) {
            return;
        }
        c1314d.f55254a.setTag(emotionImageData.getThumbUrl());
        c1314d.f55254a.M(emotionImageData.getThumbUrl(), 10, false);
        c1314d.f55255b.setVisibility(0);
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.j = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<FaceData> list = this.f55246e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            List<FaceData> list = this.f55246e;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f55246e.get(i2);
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
        C1314d c1314d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1314d = new C1314d(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
                c1314d.b(view2);
                view2.setTag(c1314d);
            } else {
                view2 = view;
                c1314d = (C1314d) view.getTag();
            }
            FaceData faceData = this.f55246e.get(i2);
            if (faceData != null) {
                int i3 = faceData.type;
                if (i3 == 4) {
                    SkinManager.setImageResource(c1314d.f55254a, R.drawable.emotion_icon_add_pic);
                    c1314d.f55255b.setVisibility(8);
                } else if (i3 == 1) {
                    c1314d.f55254a.setImageDrawable(null);
                    d(faceData.emotionImageData, viewGroup, c1314d);
                } else if (i3 == 2) {
                    c1314d.f55254a.setImageDrawable(null);
                    e(faceData.emotionImageData, c1314d);
                } else {
                    c1314d.f55254a.setImageDrawable(null);
                    c(faceData.imageFileInfo, viewGroup, c1314d);
                }
                TbImageView tbImageView = c1314d.f55254a;
                tbImageView.setTag(tbImageView.getId(), faceData);
            }
            c1314d.f55255b.setTag(faceData);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
