package io.flutter.plugins.webviewflutter;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
@TargetApi(19)
/* loaded from: classes3.dex */
public class DisplayListenerProxy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DisplayListenerProxy";
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<DisplayManager.DisplayListener> listenersBeforeWebView;

    public DisplayListenerProxy() {
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

    public static ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners(DisplayManager displayManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, displayManager)) == null) {
            if (Build.VERSION.SDK_INT >= 27) {
                return new ArrayList<>();
            }
            try {
                Field declaredField = DisplayManager.class.getDeclaredField("mGlobal");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(displayManager);
                Field declaredField2 = obj.getClass().getDeclaredField("mDisplayListeners");
                declaredField2.setAccessible(true);
                Field field = null;
                ArrayList<DisplayManager.DisplayListener> arrayList = new ArrayList<>();
                Iterator it = ((ArrayList) declaredField2.get(obj)).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (field == null) {
                        field = next.getClass().getField("mListener");
                        field.setAccessible(true);
                    }
                    arrayList.add((DisplayManager.DisplayListener) field.get(next));
                }
                return arrayList;
            } catch (IllegalAccessException | NoSuchFieldException e2) {
                String str = "Could not extract WebView's display listeners. " + e2;
                return new ArrayList<>();
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public void onPostWebViewInitialization(DisplayManager displayManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, displayManager) == null) {
            ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners = yoinkDisplayListeners(displayManager);
            yoinkDisplayListeners.removeAll(this.listenersBeforeWebView);
            if (yoinkDisplayListeners.isEmpty()) {
                return;
            }
            Iterator<DisplayManager.DisplayListener> it = yoinkDisplayListeners.iterator();
            while (it.hasNext()) {
                displayManager.unregisterDisplayListener(it.next());
                displayManager.registerDisplayListener(new DisplayManager.DisplayListener(this, yoinkDisplayListeners, displayManager) { // from class: io.flutter.plugins.webviewflutter.DisplayListenerProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DisplayListenerProxy this$0;
                    public final /* synthetic */ DisplayManager val$displayManager;
                    public final /* synthetic */ ArrayList val$webViewListeners;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, yoinkDisplayListeners, displayManager};
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
                        this.val$webViewListeners = yoinkDisplayListeners;
                        this.val$displayManager = displayManager;
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayAdded(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            Iterator it2 = this.val$webViewListeners.iterator();
                            while (it2.hasNext()) {
                                ((DisplayManager.DisplayListener) it2.next()).onDisplayAdded(i2);
                            }
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayChanged(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.val$displayManager.getDisplay(i2) == null) {
                            return;
                        }
                        Iterator it2 = this.val$webViewListeners.iterator();
                        while (it2.hasNext()) {
                            ((DisplayManager.DisplayListener) it2.next()).onDisplayChanged(i2);
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayRemoved(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                            Iterator it2 = this.val$webViewListeners.iterator();
                            while (it2.hasNext()) {
                                ((DisplayManager.DisplayListener) it2.next()).onDisplayRemoved(i2);
                            }
                        }
                    }
                }, null);
            }
        }
    }

    public void onPreWebViewInitialization(DisplayManager displayManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayManager) == null) {
            this.listenersBeforeWebView = yoinkDisplayListeners(displayManager);
        }
    }
}
