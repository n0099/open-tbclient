package d.a.q0.v3.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class k extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<StickerItem> f66304e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f66305f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f66307f;

        public a(k kVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66307f = kVar;
            this.f66306e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f66307f.f66304e.get(this.f66306e * 2)).isSelect || this.f66307f.f66305f == null) {
                return;
            }
            this.f66307f.f66305f.onStickerChoosed((StickerItem) this.f66307f.f66304e.get(this.f66306e * 2));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66308e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f66309f;

        public b(k kVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66309f = kVar;
            this.f66308e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f66309f.f66304e.get((this.f66308e * 2) + 1)).isSelect || this.f66309f.f66305f == null) {
                return;
            }
            this.f66309f.f66305f.onStickerChoosed((StickerItem) this.f66309f.f66304e.get((this.f66308e * 2) + 1));
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f66310a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f66311b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f66312c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f66313d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f66314e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f66315f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f66316g;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
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

    public k() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (StickerItem) ListUtils.getItem(this.f66304e, i2) : (StickerItem) invokeI.objValue;
    }

    public void d(List<StickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f66304e = list;
        }
    }

    public void e(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.f66305f = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.f66304e)) {
                return 0;
            }
            return (int) Math.ceil(this.f66304e.size() / 2.0d);
        }
        return invokeV.intValue;
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
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_sticker, (ViewGroup) null);
                cVar = new c(this);
                cVar.f66312c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f66313d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f66310a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f66316g = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f66311b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f66314e = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f66315f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f66312c.setAutoChangeStyle(false);
            cVar.f66313d.setAutoChangeStyle(false);
            cVar.f66312c.setGifIconSupport(false);
            cVar.f66313d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f66304e, i3) instanceof StickerItem) {
                cVar.f66310a.setVisibility(0);
                if (this.f66304e.get(i3).id == -1) {
                    cVar.f66316g.setVisibility(0);
                    cVar.f66312c.setVisibility(8);
                    cVar.f66316g.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f66316g.setVisibility(8);
                    cVar.f66312c.setVisibility(0);
                    cVar.f66312c.M(this.f66304e.get(i3).img, 10, true);
                }
                cVar.f66310a.setOnClickListener(new a(this, i2));
                if (this.f66304e.get(i3).isDownLoading) {
                    cVar.f66314e.setVisibility(0);
                } else {
                    cVar.f66314e.setVisibility(8);
                }
                if (this.f66304e.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f66310a, R.drawable.bg_select_sticker);
                } else {
                    cVar.f66310a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f66310a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f66304e, i4) instanceof StickerItem) {
                cVar.f66311b.setVisibility(0);
                cVar.f66313d.M(this.f66304e.get(i4).img, 10, true);
                cVar.f66311b.setOnClickListener(new b(this, i2));
                if (this.f66304e.get(i4).isDownLoading) {
                    cVar.f66315f.setVisibility(0);
                } else {
                    cVar.f66315f.setVisibility(8);
                }
                if (this.f66304e.get(i4).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f66311b, R.drawable.bg_select_sticker);
                } else {
                    cVar.f66311b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f66311b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
