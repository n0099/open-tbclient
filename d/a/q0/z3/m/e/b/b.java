package d.a.q0.z3.m.e.b;

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
    public List<QmStickerItem> f67630e;

    /* renamed from: f  reason: collision with root package name */
    public RecordEffectLayout.i f67631f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f67632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f67633f;

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
            this.f67633f = bVar;
            this.f67632e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f67633f.f67630e.get(this.f67632e * 2)).isSelect || this.f67633f.f67631f == null) {
                return;
            }
            this.f67633f.f67631f.a((QmStickerItem) this.f67633f.f67630e.get(this.f67632e * 2));
        }
    }

    /* renamed from: d.a.q0.z3.m.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1887b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f67634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f67635f;

        public View$OnClickListenerC1887b(b bVar, int i2) {
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
            this.f67635f = bVar;
            this.f67634e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f67635f.f67630e.get((this.f67634e * 2) + 1)).isSelect || this.f67635f.f67631f == null) {
                return;
            }
            this.f67635f.f67631f.a((QmStickerItem) this.f67635f.f67630e.get((this.f67634e * 2) + 1));
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f67636a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f67637b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f67638c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f67639d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f67640e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f67641f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f67642g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f67643h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f67644i;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (QmStickerItem) ListUtils.getItem(this.f67630e, i2) : (QmStickerItem) invokeI.objValue;
    }

    public void d(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f67630e = list;
        }
    }

    public void e(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f67631f = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.f67630e)) {
                return 0;
            }
            return (int) Math.ceil(this.f67630e.size() / 2.0d);
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
                cVar.f67638c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f67639d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f67636a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f67644i = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f67637b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f67640e = (TbImageView) view.findViewById(R.id.top_need_download);
                cVar.f67641f = (TbImageView) view.findViewById(R.id.bottom_need_download);
                cVar.f67642g = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f67643h = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f67638c.setAutoChangeStyle(false);
            cVar.f67639d.setAutoChangeStyle(false);
            cVar.f67640e.setAutoChangeStyle(false);
            cVar.f67641f.setAutoChangeStyle(false);
            cVar.f67638c.setGifIconSupport(false);
            cVar.f67639d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f67630e, i3) instanceof QmStickerItem) {
                cVar.f67636a.setVisibility(0);
                if (this.f67630e.get(i3).id == -1) {
                    cVar.f67644i.setVisibility(0);
                    cVar.f67638c.setVisibility(8);
                    cVar.f67644i.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f67644i.setVisibility(8);
                    cVar.f67638c.setVisibility(0);
                    cVar.f67638c.M(this.f67630e.get(i3).bgurl, 10, true);
                }
                cVar.f67636a.setOnClickListener(new a(this, i2));
                if (this.f67630e.get(i3).isDownLoading) {
                    cVar.f67642g.setVisibility(0);
                    cVar.f67640e.setVisibility(8);
                } else {
                    cVar.f67642g.setVisibility(8);
                    if (this.f67630e.get(i3).isLocalSource) {
                        cVar.f67640e.setVisibility(8);
                    } else {
                        cVar.f67640e.setVisibility(0);
                    }
                }
                if (this.f67630e.get(i3).isSelect) {
                    cVar.f67636a.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f67636a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f67636a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f67630e, i4) instanceof QmStickerItem) {
                cVar.f67637b.setVisibility(0);
                cVar.f67639d.M(this.f67630e.get(i4).bgurl, 10, true);
                cVar.f67637b.setOnClickListener(new View$OnClickListenerC1887b(this, i2));
                if (this.f67630e.get(i4).isDownLoading) {
                    cVar.f67643h.setVisibility(0);
                    cVar.f67641f.setVisibility(8);
                } else {
                    cVar.f67643h.setVisibility(8);
                    if (this.f67630e.get(i4).isLocalSource) {
                        cVar.f67641f.setVisibility(8);
                    } else {
                        cVar.f67641f.setVisibility(0);
                    }
                }
                if (this.f67630e.get(i4).isSelect) {
                    cVar.f67637b.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f67637b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f67637b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
