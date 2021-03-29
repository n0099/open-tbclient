package d.b.e;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: f  reason: collision with root package name */
    public static b f42733f = new b();

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel f42734e;

    /* loaded from: classes.dex */
    public static class b implements VoiceManager.i {

        /* renamed from: e  reason: collision with root package name */
        public String f42735e;

        /* renamed from: f  reason: collision with root package name */
        public VoiceManager f42736f;

        /* renamed from: g  reason: collision with root package name */
        public VoiceData$VoiceModel f42737g;

        public b() {
            this.f42735e = "";
            this.f42736f = VoiceManager.instance();
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void a(int i) {
        }

        public boolean b(VoiceData$VoiceModel voiceData$VoiceModel) {
            return this.f42736f.isPlaying(voiceData$VoiceModel);
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void c(VoiceData$VoiceModel voiceData$VoiceModel) {
        }

        public boolean d(String str) {
            String str2 = this.f42735e;
            return str2 != null && str2.equals(str);
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void e() {
        }

        public boolean f(TbPageContext tbPageContext, String str) {
            if (d(str)) {
                return false;
            }
            this.f42735e = str;
            this.f42736f.onCreate(tbPageContext);
            return true;
        }

        public void g(TbPageContext tbPageContext, String str) {
            if (d(str)) {
                this.f42736f.onDestory(tbPageContext);
                this.f42735e = null;
            }
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public VoiceManager.i getRealView() {
            return null;
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public VoiceData$VoiceModel getVoiceModel() {
            return this.f42737g;
        }

        public void h(VoiceData$VoiceModel voiceData$VoiceModel) {
            this.f42737g = voiceData$VoiceModel;
        }

        public void i() {
            this.f42736f.startPlay(this);
        }

        @Override // com.baidu.tbadk.core.voice.VoiceManager.i
        public void onShowErr(int i, String str) {
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "audioplayplugin");
        this.f42734e = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f42734e.setMethodCallHandler(null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        char c2;
        String str = methodCall.method;
        switch (str.hashCode()) {
            case 3443508:
                if (str.equals("play")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3540994:
                if (str.equals(IntentConfig.STOP)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1046116283:
                if (str.equals(MissionEvent.MESSAGE_CREATE)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1385449135:
                if (str.equals("getPlatformVersion")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1671767583:
                if (str.equals("dispose")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                f42733f.f(((TbPageContextSupport) currentActivity).getPageContext(), (String) methodCall.argument("page_name"));
            }
            result.success(Boolean.TRUE);
        } else if (c2 == 1) {
            Activity currentActivity2 = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity2 instanceof TbPageContextSupport) {
                f42733f.g(((TbPageContextSupport) currentActivity2).getPageContext(), (String) methodCall.argument("page_name"));
            }
            result.success(Boolean.TRUE);
        } else if (c2 == 2) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (c2 != 3) {
            if (c2 != 4) {
                result.notImplemented();
                return;
            }
            f42733f.f42736f.stopPlay();
            result.success(Boolean.TRUE);
        } else {
            VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
            voiceData$VoiceModel.voiceId = (String) methodCall.argument("url");
            voiceData$VoiceModel.duration = Integer.valueOf((String) methodCall.argument("duration")).intValue();
            if (!f42733f.b(voiceData$VoiceModel)) {
                f42733f.h(voiceData$VoiceModel);
                f42733f.i();
            }
            result.success(Boolean.TRUE);
        }
    }
}
