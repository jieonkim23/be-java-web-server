package Controller;

import Request.HttpRequest;
import Response.HttpResponse;
import util.HttpResponseUtil;
import util.ManageDB;
import util.StatusCode;

import java.io.DataOutputStream;

public class JoinController extends Controller {

    public JoinController(HttpRequest httpRequest, DataOutputStream dos) {
        super(httpRequest, dos);
    }

    @Override
    public void response() {
        super.response();
        ManageDB.saveUser(this.httpRequest);
        HttpResponse httpResponse = HttpResponse.createHttpResponse(this.httpRequest, StatusCode.FOUND);
        httpResponse.putHeaders("Location", "/index.html");
        httpResponse.putHeaders("Content-Length", "0");
        HttpResponseUtil.outResponse(dos, httpResponse);
    }
}
