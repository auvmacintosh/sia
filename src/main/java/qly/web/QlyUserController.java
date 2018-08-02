package qly.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qly.data.QlyUser;
import qly.data.QlyUserRepo;

@Controller
@RequestMapping("/user")
public class QlyUserController {

    private QlyUserRepo qlyUserRepo;

    @Autowired
    public QlyUserController(QlyUserRepo qlyUserRepo) {
        this.qlyUserRepo = qlyUserRepo;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String spittles(@PathVariable("userId") long id,
                           Model model) {
        QlyUser qlyUser = qlyUserRepo.findUserById(id);
        model.addAttribute(qlyUser);
        return "user";
    }

}
