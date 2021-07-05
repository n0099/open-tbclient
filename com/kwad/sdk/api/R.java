package com.kwad.sdk.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class drawable {
        public static /* synthetic */ Interceptable $ic;
        public static final int ksad_default_app_icon;
        public static final int ksad_notification_default_icon;
        public static final int ksad_notification_install_bg;
        public static final int ksad_notification_progress;
        public static final int ksad_notification_small_icon;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(103704795, "Lcom/kwad/sdk/api/R$drawable;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(103704795, "Lcom/kwad/sdk/api/R$drawable;");
                    return;
                }
            }
            ksad_default_app_icon = com.kwad.sdk.R.drawable.ksad_default_app_icon;
            ksad_notification_default_icon = com.kwad.sdk.R.drawable.ksad_notification_default_icon;
            ksad_notification_install_bg = com.kwad.sdk.R.drawable.ksad_notification_install_bg;
            ksad_notification_progress = com.kwad.sdk.R.drawable.ksad_notification_progress;
            ksad_notification_small_icon = com.kwad.sdk.R.drawable.ksad_notification_small_icon;
        }

        public drawable() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class id {
        public static /* synthetic */ Interceptable $ic;
        public static final int ksad_download_icon;
        public static final int ksad_download_install;
        public static final int ksad_download_name;
        public static final int ksad_download_percent_num;
        public static final int ksad_download_progress;
        public static final int ksad_download_size;
        public static final int ksad_download_status;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039603838, "Lcom/kwad/sdk/api/R$id;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2039603838, "Lcom/kwad/sdk/api/R$id;");
                    return;
                }
            }
            ksad_download_icon = com.kwad.sdk.R.id.ksad_download_icon;
            ksad_download_install = com.kwad.sdk.R.id.ksad_download_install;
            ksad_download_name = com.kwad.sdk.R.id.ksad_download_name;
            ksad_download_percent_num = com.kwad.sdk.R.id.ksad_download_percent_num;
            ksad_download_progress = com.kwad.sdk.R.id.ksad_download_progress;
            ksad_download_size = com.kwad.sdk.R.id.ksad_download_size;
            ksad_download_status = com.kwad.sdk.R.id.ksad_download_status;
        }

        public id() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class layout {
        public static /* synthetic */ Interceptable $ic;
        public static final int ksad_notification_download_completed;
        public static final int ksad_notification_download_progress;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1576175439, "Lcom/kwad/sdk/api/R$layout;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1576175439, "Lcom/kwad/sdk/api/R$layout;");
                    return;
                }
            }
            ksad_notification_download_completed = com.kwad.sdk.R.layout.ksad_notification_download_completed;
            ksad_notification_download_progress = com.kwad.sdk.R.layout.ksad_notification_download_progress;
        }

        public layout() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class xml {
        public static /* synthetic */ Interceptable $ic;
        public static final int ksad_file_paths;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1196333370, "Lcom/kwad/sdk/api/R$xml;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1196333370, "Lcom/kwad/sdk/api/R$xml;");
                    return;
                }
            }
            ksad_file_paths = com.kwad.sdk.R.xml.ksad_file_paths;
        }

        public xml() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public R() {
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
