package io.flutter.plugin.mouse;

import android.annotation.TargetApi;
import android.view.PointerIcon;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import java.util.HashMap;
@RequiresApi(24)
@TargetApi(24)
/* loaded from: classes3.dex */
public class MouseCursorPlugin {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static HashMap<String, Integer> systemCursorConstants;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MouseCursorViewDelegate mView;
    @NonNull
    public final MouseCursorChannel mouseCursorChannel;

    /* loaded from: classes3.dex */
    public interface MouseCursorViewDelegate {
        PointerIcon getSystemPointerIcon(int i2);

        void setPointerIcon(@NonNull PointerIcon pointerIcon);
    }

    public MouseCursorPlugin(@NonNull MouseCursorViewDelegate mouseCursorViewDelegate, @NonNull MouseCursorChannel mouseCursorChannel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mouseCursorViewDelegate, mouseCursorChannel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mView = mouseCursorViewDelegate;
        this.mouseCursorChannel = mouseCursorChannel;
        mouseCursorChannel.setMethodHandler(new MouseCursorChannel.MouseCursorMethodHandler(this) { // from class: io.flutter.plugin.mouse.MouseCursorPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MouseCursorPlugin this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.systemchannels.MouseCursorChannel.MouseCursorMethodHandler
            public void activateSystemCursor(@NonNull String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    this.this$0.mView.setPointerIcon(this.this$0.resolveSystemCursor(str));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointerIcon resolveSystemCursor(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (systemCursorConstants == null) {
                systemCursorConstants = new HashMap<String, Integer>(this) { // from class: io.flutter.plugin.mouse.MouseCursorPlugin.2
                    public static /* synthetic */ Interceptable $ic = null;
                    public static final long serialVersionUID = 1;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MouseCursorPlugin this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        put("alias", 1010);
                        put("allScroll", 1013);
                        put("basic", 1000);
                        put("cell", 1006);
                        put("click", 1002);
                        put("contextMenu", 1001);
                        put("copy", 1011);
                        put("forbidden", 1012);
                        put("grab", 1020);
                        put("grabbing", 1021);
                        put("help", 1003);
                        put("move", 1013);
                        put("none", 0);
                        put("noDrop", 1012);
                        put("precise", 1007);
                        put("text", 1008);
                        put("resizeColumn", 1014);
                        put("resizeDown", 1015);
                        put("resizeUpLeft", 1016);
                        put("resizeDownRight", 1017);
                        put("resizeLeft", 1014);
                        put("resizeLeftRight", 1014);
                        put("resizeRight", 1014);
                        put("resizeRow", 1015);
                        put("resizeUp", 1015);
                        put("resizeUpDown", 1015);
                        put("resizeUpLeft", 1017);
                        put("resizeUpRight", 1016);
                        put("resizeUpLeftDownRight", 1017);
                        put("resizeUpRightDownLeft", 1016);
                        put("verticalText", 1009);
                        put("wait", 1004);
                        put("zoomIn", 1018);
                        put("zoomOut", 1019);
                    }
                };
            }
            return this.mView.getSystemPointerIcon(systemCursorConstants.getOrDefault(str, 1000).intValue());
        }
        return (PointerIcon) invokeL.objValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mouseCursorChannel.setMethodHandler(null);
        }
    }
}
