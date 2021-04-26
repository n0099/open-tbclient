package d.a.h0.a.t1;

import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.security.ISchemeIoc;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c implements ISchemeIoc {
    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
    public void doStatistic(String str, String str2) {
        d.a.h0.a.z1.b.g(str, str2);
    }

    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
    public boolean needShowConfirmWindow(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
    public void showConfirmDialog(Context context, UnitedSchemeBaseDispatcher.ConfirmDialogCallback confirmDialogCallback) {
        if (confirmDialogCallback == null) {
            return;
        }
        confirmDialogCallback.onConfirm();
    }

    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeIoc
    public void showSchemeNotSupportDialog(Context context) {
    }
}
