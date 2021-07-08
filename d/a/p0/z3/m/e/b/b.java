package d.a.p0.z3.m.e.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<QmStickerItem> f66952e;

    /* renamed from: f  reason: collision with root package name */
    public RecordEffectLayout.i f66953f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66954e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f66955f;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66955f = bVar;
            this.f66954e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f66955f.f66952e.get(this.f66954e * 2)).isSelect || this.f66955f.f66953f == null) {
                return;
            }
            this.f66955f.f66953f.a((QmStickerItem) this.f66955f.f66952e.get(this.f66954e * 2));
        }
    }

    /* renamed from: d.a.p0.z3.m.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1882b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f66956e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f66957f;

        public View$OnClickListenerC1882b(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66957f = bVar;
            this.f66956e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f66957f.f66952e.get((this.f66956e * 2) + 1)).isSelect || this.f66957f.f66953f == null) {
                return;
            }
            this.f66957f.f66953f.a((QmStickerItem) this.f66957f.f66952e.get((this.f66956e * 2) + 1));
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f66958a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f66959b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f66960c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f66961d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f66962e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f66963f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f66964g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f66965h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f66966i;

        public c(b bVar) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public QmStickerItem getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (QmStickerItem) ListUtils.getItem(this.f66952e, i2) : (QmStickerItem) invokeI.objValue;
    }

    public void d(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f66952e = list;
        }
    }

    public void e(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f66953f = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.f66952e)) {
                return 0;
            }
            return (int) Math.ceil(this.f66952e.size() / 2.0d);
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_sticker, (ViewGroup) null);
                cVar = new c(this);
                cVar.f66960c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f66961d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f66958a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f66966i = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f66959b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f66962e = (TbImageView) view.findViewById(R.id.top_need_download);
                cVar.f66963f = (TbImageView) view.findViewById(R.id.bottom_need_download);
                cVar.f66964g = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f66965h = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f66960c.setAutoChangeStyle(false);
            cVar.f66961d.setAutoChangeStyle(false);
            cVar.f66962e.setAutoChangeStyle(false);
            cVar.f66963f.setAutoChangeStyle(false);
            cVar.f66960c.setGifIconSupport(false);
            cVar.f66961d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f66952e, i3) instanceof QmStickerItem) {
                cVar.f66958a.setVisibility(0);
                if (this.f66952e.get(i3).id == -1) {
                    cVar.f66966i.setVisibility(0);
                    cVar.f66960c.setVisibility(8);
                    cVar.f66966i.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f66966i.setVisibility(8);
                    cVar.f66960c.setVisibility(0);
                    cVar.f66960c.M(this.f66952e.get(i3).bgurl, 10, true);
                }
                cVar.f66958a.setOnClickListener(new a(this, i2));
                if (this.f66952e.get(i3).isDownLoading) {
                    cVar.f66964g.setVisibility(0);
                    cVar.f66962e.setVisibility(8);
                } else {
                    cVar.f66964g.setVisibility(8);
                    if (this.f66952e.get(i3).isLocalSource) {
                        cVar.f66962e.setVisibility(8);
                    } else {
                        cVar.f66962e.setVisibility(0);
                    }
                }
                if (this.f66952e.get(i3).isSelect) {
                    cVar.f66958a.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f66958a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f66958a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f66952e, i4) instanceof QmStickerItem) {
                cVar.f66959b.setVisibility(0);
                cVar.f66961d.M(this.f66952e.get(i4).bgurl, 10, true);
                cVar.f66959b.setOnClickListener(new View$OnClickListenerC1882b(this, i2));
                if (this.f66952e.get(i4).isDownLoading) {
                    cVar.f66965h.setVisibility(0);
                    cVar.f66963f.setVisibility(8);
                } else {
                    cVar.f66965h.setVisibility(8);
                    if (this.f66952e.get(i4).isLocalSource) {
                        cVar.f66963f.setVisibility(8);
                    } else {
                        cVar.f66963f.setVisibility(0);
                    }
                }
                if (this.f66952e.get(i4).isSelect) {
                    cVar.f66959b.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f66959b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f66959b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
