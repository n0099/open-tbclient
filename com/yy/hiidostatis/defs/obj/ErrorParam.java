package com.yy.hiidostatis.defs.obj;

import java.util.List;
/* loaded from: classes2.dex */
public class ErrorParam extends ParamableElem {
    public static final long serialVersionUID = -4313338615427788235L;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.defs.obj.ParamableElem
    public ErrorParam clearParams() {
        super.clearParams();
        return this;
    }

    public String toString() {
        return String.format("ErrorParam: %s" + super.toString(), new Object[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.defs.obj.ParamableElem
    public ErrorParam addParam(String str) {
        super.addParam(str);
        return this;
    }

    @Override // com.yy.hiidostatis.defs.obj.ParamableElem
    public ErrorParam addParams(List<String> list) {
        super.addParams(list);
        return this;
    }

    @Override // com.yy.hiidostatis.defs.obj.ParamableElem
    public /* bridge */ /* synthetic */ ParamableElem addParams(List list) {
        return addParams((List<String>) list);
    }
}
